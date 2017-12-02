package hrs.features.reservation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hrs.features.shared.Period;
import hrs.features.shared.PeriodImpl;

import java.time.LocalDate;

/**
 * @author Marta Motyka
 * @since 02.12.2017
 */
public class ReservationImpl implements Reservation {
    private long id;

    private long clientId;

    private String roomName;

    private LocalDate startDate;

    private LocalDate endDate;

    public ReservationImpl(long id, long clientId, String roomName, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.clientId = clientId;
        this.roomName = roomName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    @JsonIgnore
    public Period getPeriod() {
        return new PeriodImpl(startDate, endDate);
    }
}
