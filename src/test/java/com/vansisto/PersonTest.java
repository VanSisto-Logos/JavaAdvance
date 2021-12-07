package com.vansisto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private static Person person;

    @BeforeEach
    public void init() {
        person = Person.builder()
                .name("Bill")
                .dateOfBirth(LocalDate.now())
                .password("password")
        .build();
    }

    @AfterEach
    public void tearDown(){
        person = null;
    }

    @ParameterizedTest
    @CsvSource({
            "some.mail@gmail.com",
            "somemail@com.ua",
            "fsd$jhf-dj_sa;fdsj.afdjs.afjds.af@ua.ua"
    })
    void validateEmailPositiveTest(String email) {
        assertTrue(person.validateEmail(email), "Email \"" + email + "\" is not valid.");
    }

    @ParameterizedTest
    @CsvSource({
            "some.mail@com",
            "somemail@m.a",
            "fsd$jhf-dj_sa;fdsj.afdjs.afjds.af"
    })
    void validateEmailNegativeTest(String email) {
        assertFalse(person.validateEmail(email), "Email \"" + email + "\" is not valid.");
    }


}
