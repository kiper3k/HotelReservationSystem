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
    public boolean isDayIncluded(LocalDate date) {
        Objects.requireNonNull(date, "Param date must not be null!");
        return startDate.isEqual(date) || (date.isAfter(startDate) && date.isBefore(endDate));
    }

    @Override
    public boolean isPeriodIncluded(Period period) {
        LocalDate startDate = period.getStartDate();
        LocalDate endDate = period.getEndDate();

        // sprawdzamy czy zawiera sie w okresie dzien pierwszy lub ostatni
        if (isDayIncluded(startDate) || isDayIncluded(endDate)) {
            return true;
        }

        // sprawzdamy czy ktorys z dni pomiedzy pierwszym a ostatnim zaiwera sie w okresie
        int days = startDate.until(endDate).getDays();

        for (int i = 1; i <= days - 1; i++) {
            if (isDayIncluded(startDate.plusDays(i))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return getStartDate() + "-" + getEndDate();
    }
}
