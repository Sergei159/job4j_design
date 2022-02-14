package ru.job4j.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class XmlConverter implements Converter {

    @Override
    public String convert(List<Employee> workers)  {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Employees.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Marshaller marshaller = null;
        try {
            marshaller = context.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employees(workers), writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        return xml;
    }
}
