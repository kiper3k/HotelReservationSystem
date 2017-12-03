package hrs;

import hrs.exception.UncaughtExceptionHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hrs.features.HotelImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hrs.features.user.User;

/**
 * @author kiper
 * @author Marta Motyka
 */
public class HotelReservationSystem {

    /**
     * This is main application entry.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Room> rooms = new ArrayList<Room>();
        
        CSVUtilsRooms csvUtilsRooms = new CSVUtilsRooms();
        rooms = csvUtilsRooms.readCSV();
        
        for(int i=0; i<rooms.size(); i++){
            System.out.println(rooms.get(i));
        }
        
        List<User> users = new ArrayList<User>();
        
        CSVUtilsUsers csvUtilsUsers = new CSVUtilsUsers();
        users = csvUtilsUsers.readCSV();
        
//        for(int i=0; i<users.size(); i++){
//            System.out.println(users.get(i));
//        }
        
        
//        Room r = new Room(5,5,50);
//        System.out.println(r);
        
    }
}
