package hrs.features.shared;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;

/**
 * @author Marta Motyka
 * @since 30.11.2017
 */
public interface PriceService {
    void loadPrices(Reader reader) throws IOException;

    void savePrices(Writer writer) throws IOException;

    void loadPrices() throws IOException;

    void savePrices() throws IOException;

    void addSeasonalPrice(SeasonalPrice seasonalPrice);

    float getPrice(RoomInfo roomInfo, LocalDate date);
}
