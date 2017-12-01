package hrs.features.client;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Optional;

/**
 * @author Marta Motyka
 * @since 21.11.2017
 */
public interface ClientManager {
    /**
     *
     * @param reader
     * @throws IOException
     */
    void loadClients(Reader reader) throws IOException;

    /**
     *
     * @param writer
     * @throws IOException
     */
    void saveClients(Writer writer) throws IOException;

    /**
     *
     * @param client
     */
    void addClient(Client client);

    /**
     *
     * @param client
     */
    void removeClient(Client client);

    /**
     *
     * @param firstName
     * @param lastName
     * @return
     */
    Optional<Client> findClient(String firstName, String lastName);
}
