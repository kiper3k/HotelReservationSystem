package hrs.features.shared;

import java.time.LocalDate;

/**
 * @author kiper
 */
public interface Period {
    LocalDate getStartDate();

    LocalDate getEndDate();

    boolean isIncluded(LocalDate localDate);
}

