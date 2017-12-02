package hrs.features.reservation;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Marta Motyka
 * @since 30.11.2017
 */
public interface ReservationService {
    void loadReservations(Reader reader) throws IOException;

    void saveReservations(Writer writer) throws IOException;

    void addReservation(ReservationInfo reservationInfo);

}
