package hrs;

import java.io.File;
import java.nio.file.Paths;

/**
 * @author Marta Motyka
 * @since 30.11.2017
 */
public final class Config {
    public static String DB_DIRECTORY = "db";

    public static String ROOMS = "rooms.csv";

    public static String RESERVATIONS = "reservations.csv";

    public static String CLIENTS = "clients.csv";

    public static String USERS = "users.csv";

    public static String SEASONAL_PRICES = "seasonal-prices.csv";

    private Config() {
    }

    public static File getRoomsFile() {
        return Paths.get(DB_DIRECTORY, ROOMS).toFile();
    }

    public static File getReservationsFile() {
        return Paths.get(DB_DIRECTORY, RESERVATIONS).toFile();

    }

    public static File getUsersFile() {
        return Paths.get(DB_DIRECTORY, USERS).toFile();

    }

    public static File getClientsFile() {
        return Paths.get(DB_DIRECTORY, CLIENTS).toFile();
    }

    public static File getSeasonalPricesFile() {
        return Paths.get(DB_DIRECTORY, SEASONAL_PRICES).toFile();
    }
}
