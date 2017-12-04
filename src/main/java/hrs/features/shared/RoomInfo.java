package hrs.features.shared;

/**
 * @author kiper
 * @author Marta Motyka
 */
public interface RoomInfo {
    /**
     * Returns room name.
     *
     * @return room name.
     */
    String getRoomName();

    /**
     * Sets room name. Room name must not be null and must not be empty string.
     *
     * @param roomName new room name.
     */
    void setRoomName(String roomName);

    /**
     * Returns room size.
     *
     * @return room size.
     */
    int getNumberOfBeds();

    /**
     * Sets room size. Room size must be greater than 0.
     *
     * @param numberOfBeds new room size.
     */
    void setNumberOfBeds(int numberOfBeds);

//    int getNumberOfOccupiedBeds();

//    void setNumberOfOccupiedBeds(int numberOfOccupiedBeds);

    float getPrice();
}
