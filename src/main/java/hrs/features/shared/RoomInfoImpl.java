package hrs.features.shared;

import hrs.exception.ApplicationException;
import hrs.util.Strings;

import java.util.Objects;

/**
 * @author Marta Motyka
 * @since 19.11.2017
 */
public class RoomInfoImpl implements RoomInfo {
    
    String roomName;
    private int numberOfBeds;
//    private int numberOfOccupiedBeds;
    private float price;
    

    public RoomInfoImpl(String roomName, int numberOfBeds, float price) {
        this.roomName = roomName;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
    }
    
    @Override
    public String getRoomName(){
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

//    @Override
//    public int getNumberOfOccupiedBeds() {
//        return numberOfOccupiedBeds;
//    }
//
//    @Override
//    public void setNumberOfOccupiedBeds(int numberOfOccupiedBeds) {
//        this.numberOfOccupiedBeds = numberOfOccupiedBeds;
//    }

    @Override
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String toString(){
        return "Id: " + this.roomName + "\tNumber of beds: " + this.numberOfBeds
                + "\tPrice: " + this.price;
    }
}
