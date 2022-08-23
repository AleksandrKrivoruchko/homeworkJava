package fileWork;
import data.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import interfaceTask.WorkWithIOFile;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class WorkXml implements WorkWithIOFile{
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(DataStorage ds) {
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(fileName));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("Список задач");
            Map<Level, List<Task>> mp = ds.getMp();
            for (Level k: mp.keySet()) {
                if (mp.get(k).isEmpty()) {
                    continue;
                }
                writer.writeStartElement("Level");
                writer.writeCharacters(k.toString());
                for (Task t : mp.get(k)) {
                    writer.writeStartElement("idTask");
                    writer.writeCharacters(Integer.toString(t.getIdTask()));
                    writer.writeEndElement();
                    MyDateTime tmp = new MyDateTime(((DataFromTaskScheduler) t).getTaskAddedTime());
                    writer.writeStartElement("addTaskDate");
                    writer.writeCharacters(tmp.getDate());
                    writer.writeEndElement();
                    writer.writeStartElement("addTaskTime");
                    writer.writeCharacters(tmp.getTime());
                    writer.writeEndElement();
                    tmp = new MyDateTime(((DataFromTaskScheduler) t).getDeadlineTask());
                    writer.writeStartElement("deadlineDate");
                    writer.writeCharacters(tmp.getDate());
                    writer.writeEndElement();
                    writer.writeStartElement("deadlineTime");
                    writer.writeCharacters(tmp.getTime());
                    writer.writeEndElement();
                    writer.writeStartElement("fullName");
                    writer.writeCharacters(((DataFromTaskScheduler) t).getFullName());
                    writer.writeEndElement();
                    writer.writeStartElement("task");
                    writer.writeCharacters(t.getTask());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void read(DataStorage ds) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {

        }
    }
}
