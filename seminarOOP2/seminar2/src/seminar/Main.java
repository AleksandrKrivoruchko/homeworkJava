package seminar;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Person natasha = new Person("Nataly", LocalDate.of(1970, Month.AUGUST, 5));
        Person alex = new Person("Alex", LocalDate.of(1972, Month.DECEMBER, 25));
        Person mary = new Person("Marie", LocalDate.of(1998, Month.APRIL, 5));
        Person marieChild1 = new Person("Max", LocalDate.of(2010, Month.JANUARY, 5));
        Person marieChild2 = new Person("Ben", LocalDate.of(2018, Month.JULY, 5));
        Person alexChild = new Person("Vi", LocalDate.of(1985, Month.AUGUST, 5));

        natasha.appendToFamily(alex);
        natasha.appendToFamily(mary);
        natasha.family.addChildren(mary);
        alex.appendToFamily(alexChild);
        mary.appendToFamily(marieChild1);
        mary.appendToFamily(marieChild2);

        GeoTree family1 = new GeoTree();
        GeoTree family2 = new GeoTree();
        System.out.println(GeoTree.getCountFamily());

        printFamily(natasha, 0);
    }

    static void printFamily(Person person, int offset) {
        if(person != null) {
            System.out.print(person.getFullName().indent(offset));
            for(Person item : person.getChildren()) {
                if(item != null) {
                    printFamily(item, offset + 4);
                }
            }
        }
    }
}
