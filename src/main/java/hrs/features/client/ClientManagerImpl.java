package hrs.features.client;

//import hrs.csv.serialization.CsvDeserializerImpl;
//import hrs.csv.serialization.CsvSerializerImpl;
import hrs.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author Marta Motyka
 * @since 25.11.2017
 */
public class ClientManagerImpl implements ClientManager {
    private static final Logger log = LoggerFactory.getLogger(ClientManagerImpl.class);

    private static ClientManagerImpl instance;

//    private ClientCsvDeserializer deserializer = new ClientCsvDeserializer();

//    private ClientCsvSerializer serializer = new ClientCsvSerializer();

    private List<Client> clients = new ArrayList<>();

    public static ClientManager getInstance() {
        if (instance == null) {
            instance = new ClientManagerImpl();
        }

        return instance;
    }

    @Override
    public void loadClients(Reader reader) throws IOException {
        clients.clear();
//        clients.addAll(deserializer.deserialize(reader).readAll());
    }

    @Override
    public void saveClients(Writer writer) throws IOException {
//        serializer.serialize(writer, clients);
    }

    @Override
    public void addClient(Client client) {
        boolean noneMatch = clients.stream()
                .noneMatch(client::equals);

        if (noneMatch) {
            clients.add(client);
        } else {
            throw new ApplicationException(
                    "Client {0} {1} already exists!",
                    client.getFirstName(),
                    client.getLastName()
            );
        }
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    public Optional<Client> findClient(String firstName, String lastName) {
        return clients.stream()
                .filter(firstNameAndLastNameEqualTo(firstName, lastName))
                .findFirst();
    }

    private Predicate<Client> firstNameAndLastNameEqualTo(String firstName, String lastName) {
        return client -> Objects.equals(client.getFirstName(), firstName) && Objects.equals(client.getLastName(), lastName);
    }
}

//class ClientCsvDeserializer extends CsvDeserializerImpl<Client> {
//    ClientCsvDeserializer() {
//        super(Client.class);
//    }
//}
//
//class ClientCsvSerializer extends CsvSerializerImpl<Client> {
//    ClientCsvSerializer() {
//        super(Client.class);
//    }
//}