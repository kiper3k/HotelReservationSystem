package hrs;

import hrs.exception.ApplicationException;
import hrs.exception.UncaughtExceptionHandlerImpl;
import hrs.features.HotelImpl;
import hrs.features.client.ClientManager;
import hrs.features.client.ClientManagerImpl;
import hrs.features.shared.PriceService;
import hrs.features.shared.PriceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hrs.Config.*;

/**
 * @author kiper
 * @author Marta Motyka
 */
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * This is main application entry.
     *
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        Application application = new Application();
//        application.run(args);
//    }
//
//    public void run(String[] args) {
//        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandlerImpl());
//
//        HotelImpl hotel = new HotelImpl();
//
//        try (FileInputStream fis = new FileInputStream(getRoomsFile())) {
//            init();
//
//            try (Reader reader = new InputStreamReader(fis)) {
//                hotel.loadRooms(reader);
//            }
//        } catch (FileNotFoundException e) {
//            log.error("Error", e);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private void init() throws IOException {
//        initClientManager();
//        initPriceService();
//    }

//    private void initPriceService() throws IOException {
//        PriceService priceService = PriceServiceImpl.getInstance();
//
//        try (Reader reader = new FileReader(Config.getSeasonalPricesFile())) {
//            priceService.loadPrices(reader);
//        }
//    }

    private void initClientManager() throws IOException {
        ClientManager clientManager = ClientManagerImpl.getInstance();

        try (Reader reader = new FileReader(Config.getClientsFile())) {
            clientManager.loadClients(reader);
        } catch (IOException e) {
            throw new ApplicationException("Nie mozna odnalezc pliku {0}.", Config.getClientsFile());
        }
    }
}
