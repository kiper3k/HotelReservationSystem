package hrs.features;

import hrs.exception.ApplicationException;
import hrs.util.Strings;

import java.util.Objects;

/**
 * @author Marta Motyka
 * @since 19.11.2017
 */
public class RoomInfoImpl implements RoomInfo {
    private String roomName;

    private int numberOfBeds;

    private int numberOfOccupiedBeds;

    public RoomInfoImpl(String roomName, int numberOfBeds) {
        setRoomName(roomName);
        setNumberOfBeds(numberOfBeds);
    }

    @Override
    public String getRoomName() {
        return roomName;
    }

    @Override
    public void setRoomName(String roomName) {
        this.roomName = Objects.requireNonNull(roomName);

        if (Strings.isBlank(roomName)) {
            throw new ApplicationException("String value must not be blank!");
        }

        if (Strings.isEmpty(roomName)) {
            throw new ApplicationException("String value must not be empty!");
        }
    }

    @Override
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    @Override
    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;

        if (numberOfBeds <= 0) {
            throw new ApplicationException("Room size must be greater than 0!");
        }
    }

    @Override
    public int getNumberOfOccupiedBeds() {
        return numberOfOccupiedBeds;
    }

    @Override
    public void setNumberOfOccupiedBeds(int numberOfOccupiedBeds) {
        this.numberOfOccupiedBeds = numberOfOccupiedBeds;
    }
}
