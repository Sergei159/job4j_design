package ru.job4j.srp;

import java.util.function.Predicate;

public class DollarSalaryReport implements Report {

    private final double dollar = 80d;

    private Store store;

    public DollarSalaryReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;\r\n");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / dollar).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}