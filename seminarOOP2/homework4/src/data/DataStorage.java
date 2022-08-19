package data;

import java.util.ArrayList;
import java.util.List;

import interfaceTask.WorkWithConsole;
public class DataStorage implements WorkWithConsole{
    List<DataFromTaskScheduler> highLevel = new ArrayList<>();
    List<DataFromTaskScheduler> middleLevel = new ArrayList<>();
    List<DataFromTaskScheduler> lowLevel = new ArrayList<>();

    @Override
    public void inputTask() {

    }

    @Override
    public StringBuilder printTask() {
        StringBuilder sb = new StringBuilder();

        return null;
    }
}
