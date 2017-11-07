/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservationsystem;

import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author kiper
 */
public interface Hotel {
    
    void loadRooms(Reader readewr);
    void saveRooms(Writer writer);
    
    void addRoom(String name, int nOfBeds);
    void deleteRoom(String name);
    
    List<ReservationInfo> findFreeRooms(Period period, List<Integer> rooms);
    boolean makeReservation(Client client, ReservationInfo request);
    
}
