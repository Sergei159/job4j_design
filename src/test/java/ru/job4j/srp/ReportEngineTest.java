package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHtmlReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new HtmlReport(store);
        StringBuilder expect = new StringBuilder()
            .append("<!DOCTYPE html>").append(System.lineSeparator())
            .append("<html>").append(System.lineSeparator())
            .append("<head>").append(System.lineSeparator())
            .append("<body>").append(System.lineSeparator())
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
    public void whenDollarSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new DollarSalaryReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / 80).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenDescSortReport() {
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
                .append(System.lineSeparator())
                .append(secondWorker.getName()).append(";")
                .append(secondWorker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(firstWorker.getName()).append(";")
                .append(firstWorker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}