
package hrs.features;

import hrs.features.client.Client;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 * @author kiper
 */
public interface Hotel {

    void loadRooms(Reader reader) throws IOException;

    void saveRooms(Writer writer) throws IOException;

    void addRoom(String name, int nOfBeds);

    void deleteRoom(String name);

    List<ReservationInfo> findFreeRooms(Period period, List<Integer> rooms);

    boolean makeReservation(Client client, ReservationInfo request);

}
