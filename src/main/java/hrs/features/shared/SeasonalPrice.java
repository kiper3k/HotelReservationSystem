package hrs.features.shared;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

/**
 * @author Marta Motyka
 * @since 30.11.2017
 */
public class SeasonalPrice {
    private LocalDate startDate;

    private LocalDate endDate;

    private float priceMultiplier;

    public SeasonalPrice(LocalDate startDate, LocalDate endDate, float priceMultiplier) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceMultiplier = priceMultiplier;
    }

    public SeasonalPrice(Period period, float priceMultiplier) {
        this(period.getStartDate(), period.getEndDate(), priceMultiplier);
    }

    private SeasonalPrice() {
    }

    @JsonIgnore
    public Period getPeriod() {
        return new PeriodImpl(startDate, endDate);
    }

    public float getPriceMultiplier() {
        return priceMultiplier;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
