package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTestTest {
    private CalculatorTest2 c;

    @BeforeEach
    void setUp() {
        c = new CalculatorTest2();
    }

    @Disabled("тест анотації")
    @Test
    void whenMinusHaveSecondParameterNullThenResultEception() {
        assertThrows(NullPointerException.class, () -> c.minus(10, null));
    }

    @Test
    void whenMinusHaveFirstParameterNullThenResultEception() {
        assertThrows(NullPointerException.class, () -> c.minus(null, 4));
    }

    @Test
    void whenSumMoreThanTenThenTrue() {
        assertTrue(c.add(13, 23) > 10);
    }

    @AfterEach
    public void tearDown() {
        c = null;
    }

    @Nested
    @DisplayName("test +")
    class AddTests {
        @Test
        void whenAddOneToOneThenResultTwo() {
            assertEquals(2, c.add(1, 1));
        }

        @Test
        void whenAddOneToTenThenResultEleven() {
            assertEquals(11, c.add(10, 1));
        }
    }

    @Nested
    @DisplayName("test -")
    class MinusTests {
        @Test
        void whenTenMinusOneThenResultNine() {
            assertEquals(9, c.minus(10, 1));
        }

        @Test
        void whenTenMinusElevenThenResultMinusOne() {
            assertEquals(-1, c.minus(10, 11));
        }
    }

    @Nested
    @DisplayName("test /")
    class DivideTests {
        @Test
        void whenDivideTenByZeroThenException() {
            assertThrows(ArithmeticException.class, () -> c.divide(10, 0));
        }

        @Test
        void whenDivideTenByTwoThenResultFive() {
            assertEquals(5, c.divide(10, 2));
        }
    }

    @Nested
    @DisplayName("test *")
    class MultiplyTests {
        @Test
        void whenMultiplyOneByOneThenResultOne() {
            assertEquals(1, c.multiply(1, 1));
        }

        @DisplayName("множення: 5*10=50")
        @Test
        void whenMultiplyFiveByTenOThenResultFifteen() {
            assertEquals(50, c.multiply(5, 10), 0.01);
        }
    }

    @Nested
    @DisplayName("test ParameterizedTest")
    class ParameterizedTestTest {
        @ParameterizedTest
        @ValueSource(ints = {1,2,3})
        void whereOneTwoThree(int value) {
            assertTrue(value > 0);
        }
    }
    @Nested
    @DisplayName("test CsvSource")
    class CsvSourceTest {
        @ParameterizedTest
        @CsvSource({
                "2, 3, 5",
                "100, 50, 150",
                "250, 250, 500",
                "1, 0, 1",
                "1, -4, -3"
        })
        void csvSourceTest(int a, int b, int expected) {
            assertEquals(expected, c.add(a, b));
        }
    }
}
