package hrs.features;

import hrs.Config;
import hrs.csv.serialization.CsvDeserializerImpl;
import hrs.csv.serialization.CsvSerializerImpl;
import hrs.exception.ApplicationException;
import hrs.features.client.Client;
import hrs.features.reservation.ReservationInfo;
import hrs.features.shared.*;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author Marta Motyka
 * @since 21.11.2017
 */
public class HotelImpl implements Hotel {

    private final RoomInfoCsvDeserializer deserializer = new RoomInfoCsvDeserializer();

    private final RoomInfoCsvSerializer serializer = new RoomInfoCsvSerializer();

    private final List<RoomInfo> roomInfoStore = new ArrayList<>();

    private final PriceService priceService = new PriceServiceImpl(Config.SEASONAL_PRICES);

    @Override
    public void loadRooms(Reader reader) throws IOException {
        roomInfoStore.clear();
        roomInfoStore.addAll(
                deserializer.deserialize(reader).readAll()
        );
    }

    @Override
    public void saveRooms(Writer writer) throws IOException {
        serializer.serialize(writer, roomInfoStore);
    }

    @Override
    public void addRoom(String name, int nOfBeds, float price) {
        boolean nameIsUnique = roomInfoStore
                .parallelStream()
                .noneMatch(nameEqualTo(name));

        if (nameIsUnique) {
            roomInfoStore.add(new RoomInfoImpl(name, nOfBeds, price));
        } else {
            throw new ApplicationException("Nazwa pokoju '{}' jest juz zajeta.", name);
        }
    }

    @Override
    public void deleteRoom(String name) {
        roomInfoStore.removeIf(nameEqualTo(name));
    }

    @Override
    public List<ReservationInfo> findFreeRooms(Period period, List<Integer> rooms) {
        return null;
    }

    @Override
    public boolean makeReservation(Client client, ReservationInfo request) {
        RoomInfo room = request.getRoomInfo();
        priceService.getPrice(room, LocalDate.now());

        return false;
    }

    private Predicate<RoomInfo> nameEqualTo(String name) {
        return roomInfo -> Objects.equals(roomInfo.getRoomName(), name);
    }
}

class RoomInfoCsvDeserializer extends CsvDeserializerImpl<RoomInfo> {
    RoomInfoCsvDeserializer() {
        super(RoomInfo.class);
    }
}

class RoomInfoCsvSerializer extends CsvSerializerImpl<RoomInfo> {
    RoomInfoCsvSerializer() {
        super(RoomInfo.class);
    }
}