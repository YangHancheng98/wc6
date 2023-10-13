package q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static public int minOperations(String s1, String s2, int x) {
        List<Integer> needFlip = new ArrayList<>();
        int differenceDigit = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differenceDigit++;
                needFlip.add(i);
            }
        }

        if (differenceDigit % 2 != 0) {
            return -1;
        }
        int[] dp = new int[needFlip.size() + 1];   //dp[0]: 有0个需要翻转的字符 空字符串和空字符串
                                                    //dp[1]: 到第一个需要翻转的字符位置为止 以c,d为例，就是[1] 和 [0]，直接翻转，代价为6/2=3
                                                        //(后面还有一个数可以蹭，但这里先不考虑)
                                                    //dp[2]:到第2个需要翻转的字符位置为止 [1,0,1] 和 [0,0,0],从0翻转到2，连翻两次，代价为2
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= needFlip.size(); i++) {
            dp[i] = dp[i - 1] + x;  // 第一种方法翻转，直接加x
            if (i >= 2) {   // 第一种方法和第二种方法相比：
                dp[i] = Math.min(dp[i], dp[i - 2] + 2 * (needFlip.get(i - 1) - needFlip.get(i - 2)));
                // 第二种方法的递推公式： 从位置i-1 到i-2的index差 *2， 相当于从i-1到i-2的两个位置只见进行连续的邻位一起反转，cost为2*1
                // （都翻倍方便计算）
                // 为什么要从i-2开始？因为dp[i-1]和dp[i-2]构成了一组新的翻转组合
            }
        }

        return dp[needFlip.size()]/2;

    }

    public static void main(String[] args) {
//        String a = new String("1100011000");
//        String b = new String("0101001010");
//        System.out.println(minOperations(a, b, 2));

        String c = new String("101101");
        String d = new String("000000");
        System.out.println(minOperations(c, d, 6));


    }
}
