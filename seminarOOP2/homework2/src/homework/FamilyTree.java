package homework;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements WorkWithPerson{
    List<Object> family = new ArrayList<>();

    @Override
    public void addPerson(Object o) {
        family.add(o);
    }

    @Override
    public String personToString(Object o, String indent) {
        StringBuilder sb = new StringBuilder();
        for (var item : ((FamilyTree) o).family){
            sb.append(((Person) item).personToString((Person) item, indent));;
        }
        return sb.toString();
    }
}
