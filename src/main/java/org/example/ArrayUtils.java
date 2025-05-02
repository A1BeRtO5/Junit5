package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayUtils {
    public int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
    public boolean hasDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return true; // Якщо не вдалося додати елемент у set, це означає, що він вже є
            }
        }
        return false; // Якщо всі елементи унікальні
    }
}