package fileWork;
import data.*;

import interfaceTask.WorkWithIOFile;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class WorkXml implements WorkWithIOFile{
    private String fileName;

    public WorkXml(String s) {
        fileName = s;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(DataStorage ds) {
        String txt = createXmlText(ds).toString();
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(txt);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public DataStorage read() {
        DataStorage ds = new DataStorage<>();
        File file = new File(fileName);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            Node root = document.getDocumentElement();
            NodeList tmp = root.getChildNodes();
            for (int i = 0; i < tmp.getLength(); i++) {
                Node tmp1 = tmp.item(i);
                if (tmp1.getNodeType() != Node.TEXT_NODE) {
                    NodeList tmp2 = tmp1.getChildNodes();
                    System.out.println(tmp1.getNodeName());
                    for (int j = 0; j < tmp2.getLength(); j++) {
                        Node tmp3 = tmp2.item(j);
                        if (tmp3.getNodeType() != Node.TEXT_NODE) {
                            System.out.println("---" + j);
                            NodeList tmp4 = tmp3.getChildNodes();
                            for (int k = 0; k < tmp4.getLength(); k++) {
                                Node tmp5 = tmp4.item(k);
                                if (tmp5.getNodeType() != Node.TEXT_NODE) {
                                    System.out.println("****" + k);
                                    System.out.println(tmp5.getNodeName()
                                            + " : " +
                                            tmp5.getChildNodes().item(0)
                                                    .getTextContent());
                                }
                            }
                        }


                    }
                    System.out.println(i);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ds;
        }

        private Level getLevel(String s) {
            Level l;
            if (s.equals("HIGH")) {
                l = Level.HIGH;
            } else if (s.equals("MIDDLE")) {
                l = Level.MIDDLE;
            } else {
                l = Level.LOW;
            }
            return l;
        }

    private StringBuilder createXmlText(DataStorage ds) {
        StringBuilder sb = new StringBuilder();
        String indent = "    ";
        String indent2 = indent + indent;
        String indent3 = indent2 + indent;
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<listTasks>\n");
        Map<Level, List<Task>> hm = ds.getHm();
        for (Level l : hm.keySet()) {
            if(hm.get(l).isEmpty()) {
                continue;
            }
            sb.append(indent).append("<").append(l).append(">\n");
            for (Task t : hm.get(l)) {
                sb.append(indent2).append("<task>\n");
                sb.append(indent3).append("<id>").append(t.getIdTask())
                        .append("</id>\n");
                MyDateTime tmp = new MyDateTime(((DataFromTaskScheduler) t)
                        .getTaskAddedTime());
                sb.append(indent3).append("<addDate>").append(tmp.getDate())
                        .append("</addDate>\n");
                sb.append(indent3).append("<addTime>").append(tmp.getTime())
                        .append("</addTime>\n");
                tmp = new MyDateTime(((DataFromTaskScheduler) t)
                        .getDeadlineTask());
                sb.append(indent3).append("<deadlineDate>").append(tmp.getDate())
                        .append("</deadlineDate>\n");
                sb.append(indent3).append("<deadlineTime>").append(tmp.getTime())
                        .append("</deadlineTime>\n");
                sb.append(indent3).append("<fullName>")
                        .append(((DataFromTaskScheduler) t).getFullName())
                        .append("</fullName>\n");
                sb.append(indent3).append("<textTask>").append(t.getTask())
                        .append("</textTask>\n");
                sb.append(indent2).append("</task>\n");
            }
            sb.append(indent).append("</").append(l).append(">\n");
        }
        sb.append("</listTasks>");
        return sb;
    }
}
