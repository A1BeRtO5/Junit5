package org.example;

public class MathUtils {
    public int square (int x) {//квадрат числа
        return x*x;
    }
    public boolean isEven(Integer x) {
        if (x == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return x % 2 == 0; //перевірка на парність
    }
    public int[] testArr (int[] arr) {
        return arr;
    }
}
