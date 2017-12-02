package hrs.features.shared;

import hrs.csv.serialization.CsvDeserializerImpl;
import hrs.csv.serialization.CsvSerializerImpl;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marta Motyka
 * @since 30.11.2017
 */
public class PriceServiceImpl implements PriceService {
    private final SeasonalPriceCsvDeserializer deserializer = new SeasonalPriceCsvDeserializer();

    private final SeasonalPriceCsvSerializer serializer = new SeasonalPriceCsvSerializer();

    private final List<SeasonalPrice> seasonalPriceStore = new ArrayList<>();

    private final Path path;

    public PriceServiceImpl(String seasonalPrices) {
        path = Paths.get(seasonalPrices);
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
    public void loadPrices() throws IOException {
        try (FileReader reader = new FileReader(path.toFile())) {
            loadPrices(reader);
        }
    }

    @Override
    public void savePrices() throws IOException {
        try (FileWriter writer = new FileWriter(path.toFile())) {
            savePrices(writer);
        }
    }

    @Override
    public void addSeasonalPrice(SeasonalPrice seasonalPrice) {
        seasonalPriceStore.add(seasonalPrice);
    }

    @Override
    public float getPrice(RoomInfo roomInfo, LocalDate date) {
        return seasonalPriceStore.stream()
                .filter(seasonalPrice -> seasonalPrice.getPeriod().isDayIncluded(date))
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