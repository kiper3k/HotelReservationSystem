package hrs.features.client;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Marta Motyka
 * @since 01.12.2017
 */
public class ClientBuilderTest {

    @Test
    public void testBuilder_1() {
        Client expected = new Client(
                "Marta",
                "Motyka",
                "marta.motyka@mail.com",
                "ul. Jakas Aleja 12/99, Krakow"
        );

        Client client = Client.builder()
                .firstName("Marta")
                .lastName("Motyka")
                .email("marta.motyka@mail.com")
                .address("ul. Jakas Aleja 12/99, Krakow")
                .build();

        Assert.assertEquals(expected, client);
    }

    @Test
    public void testBuilder_2() {
        Client expected = new Client(
                "Marta",
                "Motyka",
                "marta.motyka@mail.com",
                "ul. Jakas Aleja 12/99, Krakow"
        );

        // It should be equal finally to expected object
        Client client = Client.builder()
                .firstName("Marta")
                .lastName("Motyka")
                .firstName("Tomasz")
                .lastName("Kowalski")
                .email("marta.motyka@mail.com")
                .firstName("Krzysztof")
                .firstName("Marta")
                .email("jan.kowalski@mail.com")
                .email("marta.motyka@mail.com")
                .address("ul. Jakas Aleja 12/99, Krakow")
                .address("ul. Krotka, Warszawa")
                .address("ul. Jakas Aleja 12/99, Krakow")
                .lastName("Motyka")
                .build();

        Assert.assertEquals(expected, client);
    }

    @Test
    public void testBuilder_3() {
        Client expected = new Client(
                "Marta",
                "Motyka",
                "marta.motyka@mail.com",
                "ul. Jakas Aleja 12/99, Krakow"
        );

        Client.Builder builder = Client.builder();

        builder.firstName("Marta")
                .lastName("Motyka");

        builder.firstName("Tomasz")
                .lastName("Kowalski")
                .email("marta.motyka@mail.com");

        builder.firstName("Krzysztof")
                .firstName("Marta")
                .email("jan.kowalski@mail.com")
                .email("marta.motyka@mail.com")
                .address("ul. Jakas Aleja 12/99, Krakow")
                .address("ul. Krotka, Warszawa");

        builder.address("ul. Jakas Aleja 12/99, Krakow")
                .lastName("Motyka");

        // It should be equal finally to expected object
        Client client = builder.build();

        Assert.assertEquals(expected, client);
    }
}