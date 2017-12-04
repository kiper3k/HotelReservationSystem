package hrs.csv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import hrs.features.person.Person;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marta Motyka
 * @since 14.11.2017
 */
public class CsvDeserializerImplTest {

//    @Test
//    public void deserialize() throws IOException {
//        PersonCsvDeserializerImpl csvDeserializer = new PersonCsvDeserializerImpl();
//
//        try (InputStream inputStream = getClass()
//                .getClassLoader()
//                .getResourceAsStream("person.csv")) {
//
//            try (Reader reader = new InputStreamReader(inputStream)) {
//                MappingIterator<Person> iterator = csvDeserializer.deserialize(reader);
//
//                while (iterator.hasNextValue()) {
//                    Person person = iterator.nextValue();
//
//                    System.out.println(person);
//                }
//            }
//        }
//    }

    @Test
    public void emptyTest() throws IOException {
        CsvMapper mapper = (CsvMapper) new CsvMapper()
                .findAndRegisterModules();

        CsvSchema schema = mapper
                .schemaFor(Person.class)
                .withColumnSeparator(';')
                .withColumnReordering(true)
                .withHeader();

        List<Person> people = Arrays.asList(
                new Person(1, "Joanna", "Kowalska", LocalDate.of(1992, 4, 20)),
                new Person(2, "Katarzyna", "Musiał", LocalDate.of(1991, 2, 1))
        );

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        mapper.writerFor(Person.class)
                .with(schema)
                .writeValues(outputStream)
                .writeAll(people);

        System.out.println(outputStream.toString(StandardCharsets.UTF_8.name()));
    }
}