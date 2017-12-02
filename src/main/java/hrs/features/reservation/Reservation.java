package hrs.features.reservation;

import hrs.features.shared.Period;

import java.time.LocalDate;

/**
 * @author kiper
 */
public interface Reservation {
    long getId();

    long getClientId();

    String getRoomName();

    LocalDate getStartDate();

    LocalDate getEndDate();

    Period getPeriod();
}
