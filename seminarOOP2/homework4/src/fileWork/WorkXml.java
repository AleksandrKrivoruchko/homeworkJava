package fileWork;
import data.*;

import interfaceTask.HelperIOFile;
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

public class WorkXml implements HelperIOFile{
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
        String[] str = new String[8];

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            Node root = document.getDocumentElement();
            NodeList tmp = root.getChildNodes();
            for (int i = 1; i < tmp.getLength(); i+=2) {
                Node l = tmp.item(i);
                NodeList tmp2 = l.getChildNodes();
                str[0] = l.getNodeName();
                for (int j = 1; j < tmp2.getLength(); j+=2) {
                    Node tmp3 = tmp2.item(j);
                    NodeList tmp4 = tmp3.getChildNodes();
                    for (int k = 1, m = 1; k < tmp4.getLength(); k+=2, m++) {
                         str[m] = tmp4.item(k).getChildNodes()
                                .item(0).getTextContent();
                    }
                    Task t = new DataFromTaskScheduler(str[7],
                            new MyDateTime(str[2], str[3]).getLocalDateTime(),
                            new MyDateTime(str[4],str[5]).getLocalDateTime(),
                            str[6], getLevel(str[0]));
                    t.setIdTask(Integer.parseInt(str[1]));
                    ds.addElement(t);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ds;
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
            sb.append(indent).append("<").append(l)
                    .append(">\n");
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
