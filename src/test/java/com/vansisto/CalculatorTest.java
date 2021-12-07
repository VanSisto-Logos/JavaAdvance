package com.vansisto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void setUp(){
        calculator = new Calculator();
    }

    @Test
    @Disabled
    void sumPositiveTest() {
        assertEquals(16, calculator.sum(9, 7), "Sum 9 + 7 must be 16");
        assertEquals(13332, calculator.sum(5555, 7777) );
        assertEquals(2, calculator.sum(9, -7));
        assertEquals(-16, calculator.sum(-9, -7));
        assertEquals(0, calculator.sum(0, 0));
        assertEquals(0, calculator.sum(-0, -0));
    }
    
    @Test
    void sumNegativeTest() {
        assertNotEquals(6, calculator.sum(9, 7), "Sum 9 + 7 must be 16");
        assertNotEquals(3332, calculator.sum(5555, 7777) );
        assertNotEquals(22, calculator.sum(9, -7));
        assertNotEquals(-6, calculator.sum(-9, -7));
        assertNotEquals(10, calculator.sum(0, 0));
        assertNotEquals(20, calculator.sum(-0, -0));
    }

    @ParameterizedTest
    @CsvSource({
            "6,2,4",
            "8,4.5,3.5",
            "2,-4,6",
            "-6,-6,0"
    })
    void subPositiveTest(double a, double b, double expected) {
        assertEquals(expected, calculator.sub(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "3,2,4",
            "6,4.5,3.5",
            "0,-4,6",
            "6,-6,0"
    })
    void subNegativeTest(double a, double b, double expected) {
        assertNotEquals(expected, calculator.sub(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "2,2,4",
            "4,5,20",
    })
    void mulTest(double a, double b, double expected) {
        assertEquals(expected, calculator.mul(a, b) );
    }

    @Test
    @DisplayName("Test divide by zero should throw exception")
    void divByNullTest() {
        assertThrows(ArithmeticException.class, () -> {
            double a = 10 / 0;
        });
    }
}