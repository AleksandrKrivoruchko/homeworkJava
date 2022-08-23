package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaceTask.WorkWithConsole;
public class DataStorage <T extends Task> implements WorkWithConsole{
    Map<Level, List<T>> mp = new HashMap<>();

    public DataStorage() {
        mp.put(Level.HIGH, new ArrayList<>());
        mp.put(Level.MIDDLE, new ArrayList<>());
        mp.put(Level.LOW, new ArrayList<>());
    }

    public Map<Level, List<T>> getMp() {
        return mp;
    }

    public void addElement(T d) {
        mp.get(d.getLevel()).add(d);
    }
    @Override
    public void inputTask() {

    }

    @Override
    public StringBuilder printTask() {
        StringBuilder sb = new StringBuilder();
        for (Level k: mp.keySet()) {
            if(mp.get(k).isEmpty()) continue;
            sb.append("Приоритет задачи " +k.getName() + ":\n");
            for (var v: mp.get(k)) {
                sb.append(v.toString() + "\n");
            }
        }
        return sb;
    }
}
