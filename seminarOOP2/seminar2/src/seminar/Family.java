package seminar;

import java.util.ArrayList;
import java.util.List;

public class Family implements Human<Person>{
    List<Person> parents = new ArrayList<>();
    List<Person> children = new ArrayList<>();
    @Override
    public List<Person> getParents() {
        return parents;
    }

    @Override
    public List<Person> getChildren() {
        return children;
    }

    @Override
    public void addParents(Person p) {
        parents.add(p);
    }

    @Override
    public void addChildren(Person p) {
        children.add(p);
    }
}
