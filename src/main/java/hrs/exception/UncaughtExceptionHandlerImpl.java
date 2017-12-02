package hrs.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * @author Marta Motyka
 * @since 18.11.2017
 */
public class UncaughtExceptionHandlerImpl implements Thread.UncaughtExceptionHandler {

    private Logger log = LoggerFactory.getLogger(UncaughtExceptionHandlerImpl.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof ApplicationException) {
            ApplicationException applicationException = (ApplicationException) e;

            String message = applicationException.getMessage();
            Object[] args = applicationException.getArgs();

            log.error(MessageFormat.format(message, args));
            return;
        }

        log.error("Unexpected error!", e);
    }
}
