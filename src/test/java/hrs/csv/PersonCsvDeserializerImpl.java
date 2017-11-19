package hrs.csv;

import hrs.csv.serialization.CsvDeserializerImpl;

/**
 * @author Marta Motyka
 * @since 14.11.2017
 */
public class PersonCsvDeserializerImpl extends CsvDeserializerImpl<Person> {
    public PersonCsvDeserializerImpl() {
        super(Person.class);
    }
}
