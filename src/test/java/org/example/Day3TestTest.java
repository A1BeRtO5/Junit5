package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day3TestTest {
    Calculator c;
    @BeforeEach
    void setUp() {
        c = new Calculator();
    }
    @Nested
    class TestAssertNotEquals {
        @Test
        void when2And3ThenNotEquals() {
            int x = 6;
            assertNotEquals(x, c.add(2, 3));
        }
        @Test
        void when2Multiply3ThenNotEquals() {
            int x = 5;
            assertNotEquals(x, c.multiply(2, 3));
        }
    }

    @Nested
    class TestArrayUtils {
        static Stream<int[]> testArrMethod() {
            return Stream.of(
                    new int[]{3, 1, 2}  // Невідсортований масив
            );
        }
        @ParameterizedTest
        @MethodSource("testArrMethod")
        void  testSort(int[] arr){
            ArrayUtils arrayUtils = new ArrayUtils();
            Arrays.sort(arr);  // Сортуємо масив перед перевіркою
            assertArrayEquals(new int[]{1, 2, 3}, arr );
        }
    }
}