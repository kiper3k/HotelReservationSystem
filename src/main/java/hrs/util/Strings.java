package hrs.util;

/**
 * @author Marta Motyka
 * @since 19.11.2017
 */
public final class Strings {

    public static boolean isNullOrEmpty(String value) {
        return value == null || isEmpty(value);
    }

    public static boolean isNullOrBlank(String value) {
        return value == null || isBlank(value);
    }

    public static boolean isEmpty(String value) {
        return value.isEmpty();
    }

    public static boolean isBlank(String value) {
        return value.trim().isEmpty();
    }

    private Strings() {
    }
}
