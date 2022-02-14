package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void whenJSONConverting() {
        MemStore store = new MemStore();
        Calendar firstDate = Calendar.getInstance();
        firstDate.set(2022, 02, 14);
        Employee firstWorker = new Employee("Ivan", null, null, 100);
        store.add(firstWorker);

        Calendar secondDate = Calendar.getInstance();
        secondDate.set(2022, 02, 15);
        Employee secondWorker = new Employee("Sergei", null, null, 50);
        store.add(secondWorker);

        JsonConverter jsonConverter = new JsonConverter();
        String result = jsonConverter.convert(store.findBy(em -> true));
        String expected = "[{\"name\":\"Ivan\",\"salary\":100.0},{\"name\":\"Sergei\",\"salary\":50.0}]";
        assertThat(result, is(expected));

    }
    @Test
    public void whenXmlConverter() {
        MemStore store = new MemStore();
        Calendar firstDate = Calendar.getInstance();
        firstDate.set(2022, 02, 14);
        Employee firstWorker = new Employee("Ivan", null, null, 100);
        store.add(firstWorker);

        Calendar secondDate = Calendar.getInstance();
        secondDate.set(2022, 02, 15);
        Employee secondWorker = new Employee("Sergei", null, null, 50);
        store.add(secondWorker);

        XmlConverter xmlConverter = new XmlConverter();
        String result = xmlConverter.convert(store.findBy(em -> true));
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<workers>\n"
                + "    <workers>\n"
                + "        <name>Ivan</name>\n"
                + "        <salary>100.0</salary>\n"
                + "    </workers>\n"
                + "    <workers>\n"
                + "        <name>Sergei</name>\n"
                + "        <salary>50.0</salary>\n"
                + "    </workers>\n"
                + "</workers>\n";
        assertThat(result, is(expected));
    }

}