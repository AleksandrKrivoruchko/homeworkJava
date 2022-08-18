package homework;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements WorkWithPerson<Person>{
    private List<Person> family = new ArrayList<>();

    public List<Person> getFamily() {
        return family;
    }

    @Override
    public void addPerson(Person p) {
        if(!contains(p))
            family.add(p);
    }

    @Override
    public String personToString(Person p, String indent) {
        return p.personToString(p, indent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person p: family) {
            sb.append(p.personToString(p, ""));
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Person o, Person p) {
        return o.compareTo(p);
    }

    @Override
    public void sort() {
        family.sort(Person::compareTo);
    }

    @Override
    public boolean contains(Person p) {
        for (Person person: family) {
            if(p.equals(person)) {
                return true;
            }
            if(person.getChildren().size() > 0) {
                if(person.contains(p)) {
                    return true;
                }
            }
        }
        return false;
    }
}
