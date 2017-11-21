package hrs.features;

import java.util.List;

/**
 * @author kiper
 */
public interface ReservationInfo {
    Period getPeriod();

    List<RoomInfo> getRoomInfo();
}
