package ru.job4j.serialization;

import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlAttribute
    private boolean isStudying;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private String name;

    private Contact contact;

    @XmlElementWrapper
    @XmlElement(name = "achievement")
    private String[] achievements;

    public Student() { }

    public boolean isStudying() {
        return isStudying;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getAchievements() {
        return achievements;
    }

    public Student(boolean isStudying, int age, String name,
                   Contact contact, String[] achievements) {
        this.isStudying = isStudying;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.achievements = achievements;
    }

    @Override
    public String toString() {
        return "Student{"
                + "isStudying=" + isStudying
                + ", age=" + age
                + ", name='" + name + '\''
                + ", Contact=" + contact
                + ", achievements=" + Arrays.toString(achievements)
                + '}';
    }
}
