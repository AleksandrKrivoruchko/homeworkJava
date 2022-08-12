package homework;

import java.util.ArrayList;
import java.util.List;

public class Person implements PersonMethods{
    String fullName;
    String gender;
    List<Person> kids = new ArrayList<>();

    @Override
    public boolean addChild(Person p) {
        return false;
    }
}
