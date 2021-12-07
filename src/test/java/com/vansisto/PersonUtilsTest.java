package com.vansisto;

import com.vansisto.lesson1.Person;
import com.vansisto.lesson1.PersonUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonUtilsTest {

    private static List<Person> people;
    private static PersonUtils personUtils;

    @BeforeAll
    public static void setUp(){
        personUtils = new PersonUtils();

        people = new ArrayList<>();
        people.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1986, 4, 3)).build());
        people.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1996, 4, 3)).build());
        people.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1989, 4, 3)).build());
        people.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1999, 4, 3)).build());
        people.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1980, 4, 3)).build());
        people.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1916, 4, 3)).build());
    }

    @Test
    void sortByAge() {
        
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1916, 4, 3)).build());
        personList.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1980, 4, 3)).build());
        personList.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1986, 4, 3)).build());
        personList.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1989, 4, 3)).build());
        personList.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1996, 4, 3)).build());
        personList.add(Person.builder().name("Bill").email("email@em.em").password("password")
                .dateOfBirth(LocalDate.of(1999, 4, 3)).build());

        assertIterableEquals(personList, personUtils.sortByAge(people));

    }

    @Test
    void getYounger() {
        assertEquals(1999, personUtils.getYounger(people).getDateOfBirth().getYear());
    }
}