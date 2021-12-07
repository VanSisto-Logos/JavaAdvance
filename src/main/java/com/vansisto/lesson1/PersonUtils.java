package com.vansisto.lesson1;

import java.util.ArrayList;
import java.util.List;

public class PersonUtils {
    public List<Person> sortByAge(List<Person> people) {
        List<Person> newList = new ArrayList<>(people);

        newList.sort((o1, o2) -> {
            int o1Year = o1.getDateOfBirth().getYear();
            int o2Year = o2.getDateOfBirth().getYear();
            return o1Year - o2Year;
        });

        return newList;
    }

    public Person getYounger(List<Person> people) {
        return people.stream().min((o1, o2) -> {
            int o1Year = o1.getDateOfBirth().getYear();
            int o2Year = o2.getDateOfBirth().getYear();
            return o2Year - o1Year;
        })
                .get();
    }
}
