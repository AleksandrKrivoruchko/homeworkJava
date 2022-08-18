package homework;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        WorkWithPerson maria = new Person(Gender.FEMALE, "Maria", LocalDate.of(1973, Month.AUGUST,
                12));
        WorkWithPerson person = new Person(Gender.FEMALE, "Svetlana" , LocalDate.of(1984,
                Month.AUGUST, 10));
        WorkWithPerson p1 = new Person(Gender.FEMALE, "Svetlana1" , LocalDate.of(1980,
                Month.APRIL, 15));
        WorkWithPerson p2 = new Person(Gender.FEMALE, "Svetlana2" , LocalDate.of(1904,
                Month.JANUARY, 10));
        WorkWithPerson p3 = new Person(Gender.FEMALE, "Sv1" , LocalDate.now());
        WorkWithPerson p4 = new Person(Gender.FEMALE, "Sv2" , LocalDate.now());
        p1.addPerson(p3);
        p1.addPerson(p4);
        System.out.println(person);
        maria.addPerson(person);
        maria.addPerson(p1);
        maria.addPerson(p2);

        System.out.println(maria);
        WorkWithPerson test = new Person(Gender.MALE, "Djeck", LocalDate.of(1943,
                Month.JANUARY, 20));
        test.addPerson(maria);
        System.out.println(test);
        System.out.println(test.equals(maria));
        WorkWithPerson t1 = new Person(Gender.MALE, "Djeck", LocalDate.of(1943,
                Month.JANUARY, 20));
        System.out.println(test.equals(t1));
        test.addPerson(person);
        String s = test.personToString(test, "");
        System.out.println(s);
        maria.sort();
        WorkWithPerson familyTree = new FamilyTree();
        familyTree.addPerson(test);
        familyTree.addPerson(maria);
        familyTree.addPerson(test);
        familyTree.addPerson(p2);
        familyTree.sort();
//        s = familyTree.toString();
        System.out.println(familyTree);
    }
}
