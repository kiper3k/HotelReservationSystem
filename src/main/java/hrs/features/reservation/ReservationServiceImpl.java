package hrs.features.reservation;

import hrs.csv.serialization.CsvDeserializerImpl;
import hrs.csv.serialization.CsvSerializerImpl;
import hrs.features.shared.Period;
import hrs.features.shared.RoomInfo;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Marta Motyka
 * @since 02.12.2017
 */
public class ReservationServiceImpl implements ReservationService {
    private final List<Reservation> reservationStore = new ArrayList<>();

    private final CsvDeserializerImpl<Reservation> deserializer = new CsvDeserializerImpl<>(Reservation.class);

    private final CsvSerializerImpl<Reservation> serializer = new CsvSerializerImpl<>(Reservation.class);

    @Override
    public void loadReservations(Reader reader) throws IOException {
        reservationStore.clear();
        reservationStore.addAll(
                deserializer.deserialize(reader).readAll()
        );
    }

    @Override
    public void saveReservations(Writer writer) throws IOException {
        serializer.serialize(writer, reservationStore);
    }

    @Override
    public void addReservation(ReservationInfo reservationInfo) {
        Period period = reservationInfo.getPeriod();
        RoomInfo room = reservationInfo.getRoomInfo();
        long clientId = reservationInfo.getClientId();

        boolean roomAvailable = reservationStore.stream()
                .filter(reservationRoomNameEqualTo(room.getRoomName()))
                .map(Reservation::getPeriod)
                .noneMatch(periodIncludesPeriod(period));

        if (roomAvailable) {
            ReservationImpl reservation = new ReservationImpl(
                    nextId(),
                    clientId,
                    room.getRoomName(),
                    period.getStartDate(),
                    period.getEndDate()
            );

            reservationStore.add(reservation);
        }
    }

    private Predicate<Reservation> reservationRoomNameEqualTo(String roomName) {
        return reservation -> reservation.getRoomName().equals(roomName);
    }

    private Predicate<Period> periodIncludesPeriod(Period period) {
        return existingPeriod -> existingPeriod.isPeriodIncluded(period);
    }

    private long nextId() {
        return reservationStore.parallelStream()
                .mapToLong(Reservation::getId)
                .max()
                .orElse(0) + 1;
    }
}
