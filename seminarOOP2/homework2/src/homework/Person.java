package homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements WorkWithPerson<Person>{
    private String fullName;
    private Gender gender;
    private LocalDate birthdate;

    private List<Person> children = new ArrayList<>();

    public Person(Gender gender, String fullName, LocalDate birthdate) {
        this.gender = gender;
        this.fullName = fullName;
        this.birthdate = birthdate;
    }

    public String getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return String.format("gender: %s, fullName: %s, birthdate: %s, count children: %d",
                gender, fullName, birthdate, children.size());
    }

    @Override
    public void addPerson(Person person) {
        children.add(person);
    }

    @Override
    public boolean equals(Object o) {
        Person p = (Person) o;
        return this.gender.equals(p.gender) &&
                this.fullName.equals(p.fullName) &&
                this.birthdate.equals(p.birthdate);
    }
}
