package hrs.features;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Marta Motyka
 * @since 14.11.2017
 */
public class PeriodImpl implements Period {

    private LocalDate startDate;

    private LocalDate endDate;

    private PeriodImpl() {
    }

    public PeriodImpl(LocalDate startDate, LocalDate endDate) {
        this.startDate = Objects.requireNonNull(startDate, "startDate must not be null!");
        this.endDate = Objects.requireNonNull(endDate, "endDate must not be null!");
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return getStartDate() + "-" + getEndDate();
    }
}
