package ru.job4j.srp;

import ru.job4j.serialization.A;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DescSortReport  implements Report {

    private Store store;

    public DescSortReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;\r\n");
        List<Employee> workers = store.findBy(filter);
        workers.sort((s1, s2) -> (int) (s1.getSalary() - s2.getSalary()));
        for (Employee employee : workers) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
