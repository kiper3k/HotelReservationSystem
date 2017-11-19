
package hrs;

import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 * @author kiper
 */
public interface Hotel {

    void loadRooms(Reader reader);

    void saveRooms(Writer writer);

    void addRoom(String name, int nOfBeds);

    void deleteRoom(String name);

    List<ReservationInfo> findFreeRooms(Period period, List<Integer> rooms);

    boolean makeReservation(Client client, ReservationInfo request);

}
