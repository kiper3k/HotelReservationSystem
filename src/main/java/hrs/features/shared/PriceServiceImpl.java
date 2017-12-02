package hrs.features.shared;

import hrs.csv.serialization.CsvDeserializerImpl;
import hrs.csv.serialization.CsvSerializerImpl;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marta Motyka
 * @since 30.11.2017
 */
public final class PriceServiceImpl implements PriceService {
    private static PriceServiceImpl instance;

    private final SeasonalPriceCsvDeserializer deserializer = new SeasonalPriceCsvDeserializer();

    private final SeasonalPriceCsvSerializer serializer = new SeasonalPriceCsvSerializer();

    private final List<SeasonalPrice> seasonalPriceStore = new ArrayList<>();

    public PriceServiceImpl() {

    }

    public static PriceService getInstance() {
        if (instance == null) {
            instance = new PriceServiceImpl();
        }

        return instance;
    }

    @Override
    public void loadPrices(Reader reader) throws IOException {
        seasonalPriceStore.clear();
        seasonalPriceStore.addAll(
                deserializer.deserialize(reader).readAll()
        );
    }

    @Override
    public void savePrices(Writer writer) throws IOException {
        serializer.serialize(writer, seasonalPriceStore);
    }

    @Override
    public void addSeasonalPrice(SeasonalPrice seasonalPrice) {
        seasonalPriceStore.add(seasonalPrice);
    }

    @Override
    public float getPrice(RoomInfo roomInfo, LocalDate date) {
        return seasonalPriceStore.stream()
                .filter(seasonalPrice -> seasonalPrice.getPeriod().isIncluded(date))
                .findFirst()
                .map(SeasonalPrice::getPriceMultiplier)
                .map(priceMultiplier -> roomInfo.getPrice() * priceMultiplier)
                .orElseGet(roomInfo::getPrice);
    }
}

class SeasonalPriceCsvDeserializer extends CsvDeserializerImpl<SeasonalPrice> {
    SeasonalPriceCsvDeserializer() {
        super(SeasonalPrice.class);
    }
}

class SeasonalPriceCsvSerializer extends CsvSerializerImpl<SeasonalPrice> {
    SeasonalPriceCsvSerializer() {
        super(SeasonalPrice.class);
    }
}