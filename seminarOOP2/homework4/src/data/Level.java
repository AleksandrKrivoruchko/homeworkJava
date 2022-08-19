package data;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public enum Level implements Iterable<String>{
    LOW, HIGH, MIDDLE;

    @Override
    public Iterator<String> iterator() {

        return null;
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<String> spliterator() {
        return Iterable.super.spliterator();
    }
}
