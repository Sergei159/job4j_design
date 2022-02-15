package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append("\r").append("\n")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("\r").append("\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHtmlReport() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new HtmlReport(store);
        StringBuilder expect = new StringBuilder()
            .append("<!DOCTYPE html>").append("\r").append("\n")
            .append("<html>").append("\r").append("\n")
            .append("<head>").append("\r").append("\n")
            .append("<body>").append("\r").append("\n")
            .append("<tr>")
                .append("<td>Name</td>")
                .append("<td>Hired</td>")
                .append("<td>Fired</td>")
                .append("<td>Salary</td>")
            .append("</tr>")
            .append("<tr>")
                .append("<td>").append(worker.getName()).append("</td>")
                .append("<td>").append(worker.getHired()).append("</td>")
                .append("<td>").append(worker.getFired()).append("</td>")
                .append("<td>").append(worker.getSalary()).append("</td>")
            .append("</tr>")
            .append("</body>").append("</head>").append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenDollarSalary() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new DollarSalaryReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append("\r").append("\n")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / DollarSalaryReport.DOLLAR).append(";")
                .append("\r").append("\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenDescSortReport() throws JAXBException {
        MemStore store = new MemStore();
        Calendar firstDate = Calendar.getInstance();
        Employee firstWorker = new Employee("Ivan", firstDate, firstDate, 100);
        store.add(firstWorker);

        Calendar secondDate = Calendar.getInstance();
        Employee secondWorker = new Employee("Ivan", secondDate, secondDate, 50);
        store.add(secondWorker);
        Report engine = new DescSortReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append("\r").append("\n")
                .append(firstWorker.getName()).append(";")
                .append(firstWorker.getSalary()).append(";")
                .append("\r").append("\n")
                .append(secondWorker.getName()).append(";")
                .append(secondWorker.getSalary()).append(";")
                .append("\r").append("\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

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

        JsonConverter jsonConverter = new JsonConverter(store);
        String result = jsonConverter.generate(em -> true);
        String expected = "[{\"name\":\"Ivan\",\"salary\":100.0},{\"name\":\"Sergei\",\"salary\":50.0}]";
        assertThat(result, is(expected));

    }
    @Test
    public void whenXmlConverter() throws JAXBException {
        MemStore store = new MemStore();
        Calendar firstDate = Calendar.getInstance();
        firstDate.set(2022, 02, 14);
        Employee firstWorker = new Employee("Ivan", null, null, 100);
        store.add(firstWorker);

        Calendar secondDate = Calendar.getInstance();
        secondDate.set(2022, 02, 15);
        Employee secondWorker = new Employee("Sergei", null, null, 50);
        store.add(secondWorker);

        XmlConverter xmlConverter = new XmlConverter(store);
        String result = xmlConverter.generate(em -> true);
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