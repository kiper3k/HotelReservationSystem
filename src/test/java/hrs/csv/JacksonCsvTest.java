package hrs.csv;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * @author Marta Motyka
 * @since 14.11.2017
 */
public class JacksonCsvTest {
    private CsvMapper mapper = (CsvMapper)new CsvMapper()
            .findAndRegisterModules();

    @Test
    public void simpleJacksonCsvTest() throws IOException {
        CsvSchema schema =  mapper
                .schemaFor(Person.class)
                .withColumnSeparator(';')
                .withColumnReordering(true)
                .withHeader();

        try (InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("person.csv")) {

            try (Reader reader = new InputStreamReader(inputStream)) {
                List<Person> people = mapper.readerFor(Person.class)
                        .with(schema)
                        .<Person>readValues(reader)
                        .readAll();

                people.forEach(System.out::println);
            }
        }
    }
}
