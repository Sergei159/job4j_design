package ru.job4j.srp;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "workers")
public class Employees {

    private List<Employee> workers;

    public Employees() {
    }

    public Employees(List<Employee> workers) {
        this.workers = workers;
    }


    public List<Employee> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Employee> workers) {
        this.workers = workers;
    }
}
