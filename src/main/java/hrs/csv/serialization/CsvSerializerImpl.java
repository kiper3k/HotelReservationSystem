package hrs.csv.serialization;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import hrs.csv.CsvUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;

/**
 * @author Marta Motyka
 * @since 14.11.2017
 */
public class CsvSerializerImpl<T> implements CsvSerializer<T> {
    private final Class<T> type;

    private final char separator;

    private final CsvMapper mapper = (CsvMapper) new CsvMapper()
            .findAndRegisterModules();

    private final CsvSchema schema;

    public CsvSerializerImpl(Class<T> type) {
        this(type, CsvUtils.SEPARATOR_DEFAULT);
    }

    public CsvSerializerImpl(Class<T> type, char separator) {
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
    public synchronized void serialize(Writer writer, Collection<T> collection) throws IOException {
        mapper.writerFor(type)
                .with(schema)
                .writeValues(writer)
                .writeAll(collection);
    }

    @Override
    public synchronized void serialize(OutputStream outputStream, Collection<T> collection) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(outputStream)) {
            serialize(writer, collection);
        }
    }

    @Override
    public Class<T> getType() {
        return type;
    }
}
