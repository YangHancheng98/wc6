package q1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static public int differenceOfSums(int n, int m) {
        List<Integer> divisible = new ArrayList<>();
        List<Integer> nonDivisible = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                divisible.add(i);
            } else {
                nonDivisible.add(i);
            }
        }

        int result = 0;
        for (int a : nonDivisible) {
            result += a;
        }
        for (int b : divisible) {
            result -= b;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(differenceOfSums(10, 3));
        System.out.println(differenceOfSums(5, 6));
        System.out.println(differenceOfSums(5, 1));

    }
}
