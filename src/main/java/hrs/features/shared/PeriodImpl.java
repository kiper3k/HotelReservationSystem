package hrs.features.shared;

import hrs.exception.ApplicationException;

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

        if (startDate.isAfter(endDate)) {
            throw new ApplicationException("Period start date ({0}) must be before end date ({1})!", startDate, endDate);
        }
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
    public boolean isIncluded(LocalDate date) {
        Objects.requireNonNull(date, "Param date must not be null!");
        return startDate.isEqual(date) || (date.isAfter(startDate) && date.isBefore(endDate));
    }

    @Override
    public String toString() {
        return getStartDate() + "-" + getEndDate();
    }
}
