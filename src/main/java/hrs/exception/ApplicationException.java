package hrs.exception;

/**
 * @author Marta Motyka
 * @since 18.11.2017
 */
public class ApplicationException extends RuntimeException {
    private final Object[] args;

    public ApplicationException(String message, Object... args) {
        super(message);
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }
}
