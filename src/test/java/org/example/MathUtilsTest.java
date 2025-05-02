package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    private MathUtils m;
    @BeforeEach
    void setUp() {
         m = new MathUtils();
    }
    @Nested
    class SquareMethodTest {
        @ParameterizedTest
        @DisplayName("перевіря метод square на отримання квардата з {2, 3, 4}")
        @ValueSource(ints = {2, 3, 4})
        void square(int x) {
            int expected = x*x;
            assertEquals(expected, m.square(x));
        }
    }
    @Nested
    class IsEvenMethodTest {
        @ParameterizedTest
        @DisplayName("перевіряє метод isEven на правильність виконання")
        @CsvSource({
            "2, true",
            "3, false",
            "5, false",
            "10, true"
        })
        void isEven(int x, boolean expected) {
            assertEquals(m.isEven(x), expected);
        }
    }
    @Nested
    class TestAssertNotEquals {
       @ParameterizedTest
        @CsvSource({
                "2, false",
                "4, false",
                "3, true"
        })
        void whenTwoDontEqualsOne(int x, boolean expected) {
        assertNotEquals(expected, x);}
    }

    @Nested
    class TestBooleanTests {
        @ParameterizedTest
        @ValueSource(ints = { 2,  4, 6})
        void testIsEvenTrue(int x) {
            assertTrue(m.isEven(x));
        }
        @ParameterizedTest
        @ValueSource(ints = {1, 3, 5, 47, 57})
        void testIsEvenFalse(int x) {
            assertFalse(m.isEven(x));
        }
    }
    @Nested
    class CheckNullTests {
        @ParameterizedTest
        @ValueSource(ints = {1, 3, 5, 47, 57})
        void testCheckNotNull(int x) {
            assertNotNull(m.isEven(x));
        }
        @ParameterizedTest
        @NullSource
        void testCheckNull(Integer x) {
            assertThrows(IllegalArgumentException.class, () ->m.isEven(x));
        }
    }
    @Nested
    class TestAssertAll {
        @Test
        void testAssertAll() {
            assertAll(
                    () -> assertEquals(4, m.square(2)),
                    () -> assertTrue(m.isEven(2)),
                    () -> assertFalse(m.isEven(5))
            );
        }
    }


}