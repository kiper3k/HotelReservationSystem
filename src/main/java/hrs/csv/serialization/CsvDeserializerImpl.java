package hrs.csv.serialization;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import hrs.csv.CsvUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author Marta Motyka
 * @since 14.11.2017
 */
public class CsvDeserializerImpl<T> implements CsvDeserializer<T> {

    private final Class<T> type;

    private final CsvSchema schema;

    private final char separator;

    private final CsvMapper mapper = (CsvMapper) new CsvMapper()
            .findAndRegisterModules();

    public CsvDeserializerImpl(Class<T> type) {
        this(type, CsvUtils.SEPARATOR_DEFAULT);
    }

    public CsvDeserializerImpl(Class<T> type, char separator) {
        this.type = type;
        this.separator = separator;

        this.schema = mapper
                .schemaFor(type)
                .withColumnSeparator(separator)
                .withColumnReordering(true)
                .withHeader();
    }

    @Override
    public char getSeparator() {
        return separator;
    }

    @Override
    public synchronized MappingIterator<T> deserialize(Reader reader) throws IOException {
        return mapper.readerFor(type)
                .with(schema)
                .readValues(reader);
    }

    @Override
    public synchronized MappingIterator<T> deserialize(InputStream inputStream) throws IOException {
        try (Reader reader = new InputStreamReader(inputStream)) {
            return deserialize(reader);
        }
    }

    @Override
    public Class<T> getType() {
        return type;
    }
}
