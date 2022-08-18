package homework;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        WorkWithPerson maria = new Person(Gender.FEMALE, "Maria Ivanova", LocalDate.of(1973, Month.AUGUST,
                12));
        WorkWithPerson person = new Person(Gender.FEMALE, "Svetlana Petrova" , LocalDate.of(1980,
                Month.AUGUST, 10));
        WorkWithPerson p1 = new Person(Gender.FEMALE, "Maria Ivanova" , LocalDate.of(1985,
                Month.APRIL, 15));
        WorkWithPerson p2 = new Person(Gender.FEMALE, "Svetlana Petrova" , LocalDate.of(1904,
                Month.JANUARY, 10));
        WorkWithPerson p3 = new Person(Gender.MALE, "Petr Sergeev" , LocalDate.of(2001,
                Month.APRIL, 30));
        WorkWithPerson p4 = new Person(Gender.MALE, "Semen Semenov" , LocalDate.now());
        p1.addPerson(p4);
        p1.addPerson(p3);


        maria.addPerson(p1);
        maria.addPerson(p2);
        maria.addPerson(person);

        System.out.println(maria);
        WorkWithPerson ivan = new Person(Gender.MALE, "Ivan", LocalDate.of(1943,
                Month.JANUARY, 20));
        ivan.addPerson(maria);
        System.out.println(ivan);

        ivan.addPerson(person);
        String s = ivan.personToString(ivan, "");
        System.out.println(s);
        maria.sort();
        WorkWithPerson familyTree = new FamilyTree();
        familyTree.addPerson(ivan);
        familyTree.addPerson(maria);
        familyTree.addPerson(ivan);
        familyTree.addPerson(p2);
        familyTree.sort();

        System.out.println(familyTree);
    }
}
