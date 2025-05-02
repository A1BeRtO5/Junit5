package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest3 {

    @Test
        void testAdd() {
        Calculator c = new Calculator();
        assertEquals(3, c.add(1,2));
    }
    @Test
    void divideByZero() {
        CalculatorTest2 c = new CalculatorTest2();
        Assertions.assertThrows(ArithmeticException.class, () -> c.divide(1,0));
    }
}
