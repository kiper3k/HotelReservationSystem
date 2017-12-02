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

/**
 * @author kiper
 * @author Marta Motyka
 */
public class HotelReservationSystem {

    private static final Logger log = LoggerFactory.getLogger(HotelReservationSystem.class);

    /**
     * This is main application entry.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Room> rooms = new ArrayList<Room>();
        
        CSVUtilsRooms csvUtilsRooms = new CSVUtilsRooms();
        
        rooms = csvUtilsRooms.readCSV();
        
        
        
//        Room r = new Room(5,5,50);
//        System.out.println(r);
        
    }
}
