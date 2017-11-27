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
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandlerImpl());

        log.info("Application is working!");
        // TODO code application logic here
        
        HotelImpl hotel = new HotelImpl();
        
        try {
            FileInputStream fis = new FileInputStream("/home/kiper/Dokumenty/UJ/Projektowanie obiektowe/HotelReservationSystem/src/test/resources/rooms.csv");
            Reader reader = new InputStreamReader(fis);
            try {
                hotel.loadRooms(reader);
//                System.out.println(hotel.getRooms());
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(HotelReservationSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        
    }
}
