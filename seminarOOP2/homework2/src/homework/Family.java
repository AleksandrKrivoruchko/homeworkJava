package homework;

import java.util.ArrayList;
import java.util.List;

public class Family implements FamilyMethods{
    List<Person> family = new ArrayList<>();
    @Override
    public boolean addFamily(Person p) {
        return false;
    }

    @Override
    public boolean isBelongToFamily(Person p) {
        return false;
    }

    @Override
    public String getFamily() {
        return null;
    }
}
