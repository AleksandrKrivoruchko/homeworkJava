import data.DataFromTaskScheduler;
import data.DataStorage;
import data.Level;
import data.Task;
import fileWork.WorkCsv;
import interfaceTask.WorkWithIOFile;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        String t = "Закончить программу";
        Task task = new DataFromTaskScheduler(t,
                LocalDateTime.of(2022, 8, 28, 12, 30),
                "Иванов Иван");

        System.out.println(task);
        task.setIdTask(20);
        Task task1 = new DataFromTaskScheduler(t,
                LocalDateTime.of(2022, 9, 10, 2, 1),
                "Семенов Семен", Level.HIGH);
        Task task2 = new DataFromTaskScheduler(t,
                LocalDateTime.of(2022, 8, 8, 2, 30),
                "Иванов Иван Иванович");
        DataStorage ds = new DataStorage();
        ds.addElement(task);
        ds.addElement(task1);
        ds.addElement(task2);
        System.out.println(ds.printTask());
        WorkWithIOFile fileWork = new WorkCsv("data.csv");
//        fileWork.save(ds);
        DataStorage ds1 = new DataStorage<>();
        fileWork.read(ds1);
        System.out.println("\n\n" + ds1.printTask());
    }
}
