package homework;

public interface WorkWithPerson <T> {
    void addPerson(T t);
    String personToString(T t, String indent);
    int compareTo(T t, T p);

    public boolean contains(T t);

    public void sort();
}
