package hrs;

import hrs.csv.CSVUtilsRooms;
import hrs.csv.CSVUtilsUsers;
import hrs.exception.UncaughtExceptionHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hrs.features.HotelImpl;
import hrs.features.shared.RoomInfo;

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
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandlerImpl());
        
        HotelImpl hotel = new HotelImpl();
        
        CSVUtilsRooms csvUtilsRooms = new CSVUtilsRooms();
//        rooms = csvUtilsRooms.readCSV();
        hotel.loadRooms(csvUtilsRooms);
        
        List<RoomInfo> rooms = new ArrayList<>();
        rooms = hotel.getRooms();
        for(int i=0; i<rooms.size(); i++){ 
            System.out.println(rooms.get(i));
        }
        
        rooms = hotel.getRooms();
        for(int i=0; i<rooms.size(); i++){ 
            System.out.println(rooms.get(i));
        }
        
        hotel.saveRooms(csvUtilsRooms);
        
        

        CSVUtilsUsers csvUtilsUsers = new CSVUtilsUsers();
//        users = csvUtilsUsers.readCSV();
        
        List<User> users = new ArrayList<User>();
        users = csvUtilsUsers.readCSV();
        
        
        
        for(int i=0; i<users.size(); i++){
            System.out.println(users.get(i));
        }
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (true) {
            input = br.readLine();
            
            if (input == "add"){
                //collect info
                hotel.addRoom("Room4", 3, 500);
            }
            else if (input == "list") {
                rooms = hotel.getRooms();
                for(int i=0; i<rooms.size(); i++){ 
                    System.out.println(rooms.get(i));
                }
            }
        }
        
    }
}
