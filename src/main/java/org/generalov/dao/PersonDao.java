package org.generalov.dao;

import org.generalov.models.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class PersonDao {
    private static int peopleCount;
    private List<Person> people;

    static {
        peopleCount = 0;
    }

    {
        people = new ArrayList<>();
        people.add(new Person(++peopleCount, "Nick"));
        people.add(new Person(++peopleCount, "Jack"));
        people.add(new Person(++peopleCount, "Rouse"));
        people.add(new Person(++peopleCount, "Victoria"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
}
