/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservationsystem;

import java.util.List;

/**
 *
 * @author kiper
 */
public interface ReservationInfo {
    
    Period getPeriod();
    List<RoomInfo> getRoomInfo();
    
}
