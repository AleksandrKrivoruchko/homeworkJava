import data.DataFromTaskScheduler;
import data.DataStorage;
import data.Level;
import data.Task;
import fileWork.WorkCsv;
import fileWork.WorkXml;
import interfaceTask.WorkWithIOFile;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        String t = "Закончить программу";
        Task task = new DataFromTaskScheduler(t,
                LocalDateTime.of(2022, 8, 28, 12, 30),
                "Иванов Иван");
        Task task1 = new DataFromTaskScheduler(t,
                LocalDateTime.of(2022, 9, 10, 2, 1),
                "Семенов Семен", Level.HIGH);
        Task task2 = new DataFromTaskScheduler(t,
                LocalDateTime.of(2022, 8, 8, 2, 30),
                "Иванов Иван Иванович");
        Task task3 = new DataFromTaskScheduler("Начать изучение языка Java",
                LocalDateTime.of(2021, 9, 4, 15, 5),
                LocalDateTime.of(2022, 9, 15, 0, 0),
                "Сидоров Петр Сергеевич", Level.MIDDLE);
        DataStorage ds = new DataStorage();
        ds.addElement(task);
        ds.addElement(task1);
        ds.addElement(task2);
        ds.addElement(task3);
        System.out.println("\tВывод списка задач из DataStore");
        System.out.println(ds.printTask());

        // Создание объекта для работы с csv
        WorkWithIOFile fileWork = new WorkCsv("data.csv");
        fileWork.save(ds);

        DataStorage ds1 = fileWork.read();
        System.out.println("\tВывод списка задач прочитанного из файла csv");
        System.out.println(ds1.printTask());

        // Создание объекта для работы с xml
        fileWork = new WorkXml("dataXML.xml");
        fileWork.save(ds1);

        DataStorage ds3 = fileWork.read();
        System.out.println("\tВывод списка задач прочитанного из файла xml");
        System.out.println(ds3.printTask());
    }
}
