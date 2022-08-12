package seminar;

import java.time.LocalDate;
import java.util.List;

public interface Human<T> {
    List<T> getParents();
    List<T> getChildren();
    void addParents(T t);
    void addChildren(T t);
}
