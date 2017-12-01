package hrs.features.reservation;

import hrs.features.shared.Period;
import hrs.features.shared.RoomInfo;

/**
 * @author Marta Motyka
 * @since 25.11.2017
 */
public class ReservationInfoImpl implements ReservationInfo {

    private Period period;

    private RoomInfo roomInfo;

    public ReservationInfoImpl(Period period, RoomInfo roomInfo) {
        this.period = period;
        this.roomInfo = roomInfo;
    }

    @Override
    public Period getPeriod() {
        return period;
    }

    @Override
    public RoomInfo getRoomInfo() {
        return roomInfo;
    }
}
