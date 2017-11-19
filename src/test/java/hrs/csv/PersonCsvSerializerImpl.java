package hrs.csv;

import hrs.csv.serialization.CsvSerializerImpl;

/**
 * @author Marta Motyka
 * @since 14.11.2017
 */
public class PersonCsvSerializerImpl extends CsvSerializerImpl<Person> {
    public PersonCsvSerializerImpl() {
        super(Person.class);
    }
}
