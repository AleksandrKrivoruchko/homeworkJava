package homework;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Person maria = new Person(Gender.FEMALE, "Maria", LocalDate.of(1973, Month.AUGUST,
                12));
        Person person = new Person(Gender.FEMALE, "Svetlana" , LocalDate.now());
        System.out.println(person);
        maria.addPerson(person);
        System.out.println(maria);
        WorkWithPerson test = new Person(Gender.MALE, "Djeck", LocalDate.of(1943,
                Month.JANUARY, 20));
        test.addPerson(maria);
        System.out.println(test);
        System.out.println(test.equals(maria));
        WorkWithPerson t1 = new Person(Gender.MALE, "Djeck", LocalDate.of(1943,
                Month.JANUARY, 20));
        System.out.println(test.equals(t1));
    }
}
