package homework;

public interface WorkWithPerson <T> {
    void addPerson(T t);
    String personToString(T t, String indent);

}
