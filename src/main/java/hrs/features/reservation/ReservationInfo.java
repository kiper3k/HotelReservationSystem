package hrs.features.reservation;

import hrs.features.shared.Period;
import hrs.features.shared.RoomInfo;

/**
 * @author kiper
 */
public interface ReservationInfo {
    Period getPeriod();

    RoomInfo getRoomInfo();

    long getClientId();
}
