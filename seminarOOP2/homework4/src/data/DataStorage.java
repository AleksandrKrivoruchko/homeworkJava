package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaceTask.WorkWithConsole;
public class DataStorage <T extends Task> implements WorkWithConsole{
    Map<Level, List<T>> hm = new HashMap<>();

    public DataStorage() {
        hm.put(Level.HIGH, new ArrayList<>());
        hm.put(Level.MIDDLE, new ArrayList<>());
        hm.put(Level.LOW, new ArrayList<>());
    }

    public Map<Level, List<T>> getHm() {
        return hm;
    }

    public void addElement(T d) {
        hm.get(d.getLevel()).add(d);
    }

    @Override
    public StringBuilder printTask() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------------\n");
        for (Level k: hm.keySet()) {
            if(hm.get(k).isEmpty()) continue;
            sb.append("\t\tПриоритет задачи " + k.getName() + ":\n");
            for (T v: hm.get(k)) {
                sb.append(v.toString() + "\n");
            }
        }
        sb.append("------------------------------------------------\n");
        return sb;
    }
}
