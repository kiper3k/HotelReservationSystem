package hrs.features.shared;

import hrs.Config;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Marta Motyka
 * @since 30.11.2017
 */
public class PriceServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(PriceServiceImplTest.class);

    private static final Random random = new Random();

    private PriceServiceImpl priceService;

    @Before
    public void before() {
//        this.priceService = new PriceServiceImpl(Config.SEASONAL_PRICES);
    }

    @Test
    public void testCalculatePriceForRandomSeason() throws IOException {
        List<SeasonalPrice> seasonalPrices = randomSeasonalPriceList();
        seasonalPrices.forEach(priceService::addSeasonalPrice);

        StringWriter writer = new StringWriter();
        priceService.savePrices(writer);

        log.info(writer.toString());

        SeasonalPrice seasonalPrice = seasonalPrices.get(random.nextInt(seasonalPrices.size()));
        float priceMultiplier = seasonalPrice.getPriceMultiplier();
        LocalDate date = randomDate(seasonalPrice);

        int expectedPrice = Math.round(80 * priceMultiplier);

        Assert.assertEquals(expectedPrice, Math.round(priceService.getPrice(new RoomInfoImpl("ROOM", 1, 80), date)));
    }

    private List<SeasonalPrice> randomSeasonalPriceList() {
        List<SeasonalPrice> result = new ArrayList<>();

        int count = random.nextInt(100);

        LocalDate lastDate = LocalDate.now();

        for (int i = 0; i < count; i++) {
            LocalDate startDate = lastDate;
            LocalDate endDate = startDate.plusDays(random.nextInt(10));

            result.add(new SeasonalPrice(startDate, endDate, random.nextFloat() + 0.5f));

            lastDate = endDate.plusDays(random.nextInt(40));
        }

        return result;
    }

    private LocalDate randomDate(SeasonalPrice seasonalPrice) {
        LocalDate startDate = seasonalPrice.getStartDate();
        LocalDate endDate = seasonalPrice.getEndDate();

        int days = startDate.until(endDate).getDays();

        return startDate.plusDays(random.nextInt(days));
    }
}