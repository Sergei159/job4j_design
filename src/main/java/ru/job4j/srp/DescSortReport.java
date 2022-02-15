package ru.job4j.srp;
import java.util.Comparator;
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
        text.append("Name; Hired; Fired; Salary;");
        List<Employee> workers = store.findBy(filter);
        workers.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        for (Employee employee : workers) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
