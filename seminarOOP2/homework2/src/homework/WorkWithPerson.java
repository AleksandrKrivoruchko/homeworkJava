package homework;

public interface WorkWithPerson <T> {
    void addPerson(T t);
    String personToString(T t, String indent);
    int compareTo(T t, T p);

    boolean contains(T t);

    void sort();
}
