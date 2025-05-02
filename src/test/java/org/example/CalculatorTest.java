package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    public void setUp() {
         calculator = new Calculator();
    }
    // +
    @Test
    void whenAddTenToFiveThenResultIsFifteen() {
        int expected1 = 15;
        int result1 = calculator.add(10, 5);
        assertEquals(expected1, result1);
    }
    @Test
    void whenAddOneHundredToFiftyThenResultIsOneHundredFifty() {
        assertEquals(150, calculator.add(100,50));
    }
    // -
    @Test
    void whenFiftyMinusTenThenResultIsForty() {
        int expected = 40;
        int result = calculator.minus(50, 10);
        assertEquals(expected, result);
    }
    @Test
    void whenFiftyMinusOneThenResultIsFortyNine() {
        int expected = 49;
        int result = calculator.minus(50, 1);
        assertEquals(expected, result);
    }
    // /
    @Test
    void whenFiftyDivideByTenThenResultIsFive() {
        double expected = 5;
        double result = calculator.divide(50, 10);
        assertEquals(expected, result, 0.01);
    }
    @Test
    void whenFiftyDivideBySevenThenResultIsAboutSevenPointOne() {
        double expected = 7;
        double result = calculator.divide(50, 7);
        assertEquals(expected, result, 0.1);
    }
    // *
    @Test
    void whenFiftyMultiplyBySevenThenResultIsThreeHundredFifty() {
        double expected = 350;
        double result = calculator.multiply(50, 7);
        assertEquals(expected, result, 0.1);
    }
    @Test
    void whenDivideByZeroThenResultException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(50, 0));
    }
    @Test
    void whenFirstParametrIsNullThenResultException() {
        assertThrows(NullPointerException.class, () -> calculator.divide(null, 3));
    }




}