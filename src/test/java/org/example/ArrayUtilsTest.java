package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    ArrayUtils a;
    @BeforeEach
    void before() {
        a = new ArrayUtils();
    }
    @Nested
    class TestAssert {
        public static Stream<int[]> testArrWithoutDuplicates() {
            return Stream.of(
                    new int[] {1, 2, 3, 4, 5}
            );
        }
        public static Stream<int[]> testArrWithDuplicates() {
            return Stream.of(
                    new int[] {1, 2, 2, 4, 5}
            );
        }
        public static Stream<int[]> testArrWithOneElement() {
            return Stream.of(
                    new int[] {1}
            );
        }
        public static Stream<int[]> testEmptyArr() {
            return Stream.of(
                    new int[] {}
            );
        }

        @ParameterizedTest
        @MethodSource("testArrWithoutDuplicates")
        void testWithoutDuplicates(int[] arr) {
            assertFalse(a.hasDuplicates(arr));
        }
        @ParameterizedTest
        @MethodSource("testArrWithDuplicates")
        void testWithDuplicates(int[] arr) {
            assertTrue(a.hasDuplicates(arr));
        }
        @Test
        void test() {
            assertFalse(a.hasDuplicates(new int[] {1}));
            assertFalse(a.hasDuplicates(new int[] {}));
        }
    }

}