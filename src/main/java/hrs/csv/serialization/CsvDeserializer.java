package hrs.csv.serialization;

import com.fasterxml.jackson.databind.MappingIterator;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * @author Marta Motyka
 * @since 14.11.2017
 */
public interface CsvDeserializer<T> {
    char getSeparator();

    MappingIterator<T> deserialize(Reader reader) throws IOException;

    MappingIterator<T> deserialize(InputStream inputStream) throws IOException;

    Class<T> getType();
}
