
package hrs.features;

import hrs.CSVUtilsRooms;
import hrs.features.client.Client;
import hrs.features.reservation.ReservationInfo;
import hrs.features.shared.Period;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 * @author kiper
 * @author Marta Motyka
 */
public interface Hotel {

//    void loadRooms(Reader reader) throws IOException;
    void loadRooms(CSVUtilsRooms rooms) throws IOException;

//    void saveRooms(Writer writer) throws IOException;

    /**
     * Adds new room.
     *
     * @param name    is a name of the room
     * @param nOfBeds is a number of beds in room
     */
//    void addRoom(String name, int nOfBeds, float price);

    /**
     * Deletes room.
     *
     * @param name is a name of the room
     */
//    void deleteRoom(String name);

    /**
     * @param period jest okresem w którym chcemy zarezerwować pokoje
     * @param rooms  jest listą liczb określających ile osób chcemy zakwaterować w pokoju np.: {1, 2} oznacza, że
     *               potrzebujemy pokoju dla jednej osoby i drugiego pokoju dla dwóch osób
     * @return
     */
//    List<ReservationInfo> findFreeRooms(Period period, List<Integer> rooms);

    /**
     * Makes reservation for client using Client and ReservationInfo.
     *
     * @param client is an information about client
     * @param request is an information about reservation
     * @return
     */
//    boolean makeReservation(Client client, ReservationInfo request);

}
