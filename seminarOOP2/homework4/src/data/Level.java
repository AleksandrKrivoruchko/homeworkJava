package data;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public enum Level {
    LOW("Низкий"), HIGH("Высокий"), MIDDLE("Средний");
    private String name;
    private Level(String s){
        name = s;
    }

    public String getName() {
        return name;
    }
}
