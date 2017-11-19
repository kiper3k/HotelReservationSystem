package hrs.csv.serialization;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Collection;

/**
 * @author Marta Motyka
 * @since 14.11.2017
 */
public interface CsvSerializer<T> {
    char getSeparator();

    void serialize(Writer writer, Collection<T> collection) throws IOException;

    void serialize(OutputStream outputStream, Collection<T> collection) throws IOException;

    Class<T> getType();
}
