package hrs;

import hrs.exception.UncaughtExceptionHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    }
}
