package fileWork;

import data.*;
import interfaceTask.WorkWithIOFile;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorkCsv implements WorkWithIOFile {
    private String fileName;

    public WorkCsv(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(DataStorage ds) {
        File file = new File(fileName);
        try {
            FileWriter fw = new FileWriter(file);
            Map<Level, List<Task>> mp = ds.getMp();
            for (Level k: mp.keySet()) {
                if(mp.get(k).isEmpty()) {
                    continue;
                }
                for (Task t : mp.get(k)) {
                    MyDateTime addTask = new MyDateTime(((DataFromTaskScheduler) t).getTaskAddedTime());
                    MyDateTime endTask = new MyDateTime(((DataFromTaskScheduler) t).getDeadlineTask());
                    fw.write(t.getLevel() + ",");
                    fw.write(t.getIdTask() + ",");
                    fw.write(addTask.getDate() + ",");
                    fw.write(addTask.getTime() + ",");
                    fw.write(endTask.getDate() + ",");
                    fw.write(endTask.getTime() + ",");
                    fw.write(((DataFromTaskScheduler) t).getFullName() + ",");
                    fw.write(t.getTask() + "\n");
                }
            }
            fw.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void read(DataStorage ds) {
        List<String> ls = new ArrayList<>();
        try {
            ls = Files.readAllLines(Paths.get(fileName));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        for (String s : ls) {
            if(s.equals("")) {
                continue;
            }
                String[] arr = s.split(",");
                Level l = getLevel(arr[0]);
                MyDateTime add = new MyDateTime(arr[2], arr[3]);
                MyDateTime end = new MyDateTime(arr[4], arr[5]);
                Task task = new DataFromTaskScheduler(arr[7],
                        add.getLocalDateTime(),
                        end.getLocalDateTime(),
                        arr[6], l);
                task.setIdTask(Integer.parseInt(arr[1]));
                ds.addElement(task);

        }
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
}
