package q2;
import java.util.*;
// 贪心：把占用时间越短的放在越后面
public class Solution {

    static public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int result = Integer.MIN_VALUE;

        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());

        for (int i = 0; i < processorTime.size(); i++) {
            int startTime = processorTime.get(i);
            for (int j = 4 * i; j < tasks.size(); j++) {
                result = Math.max(startTime + tasks.get(j), result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> processorTime = new ArrayList<>();
        processorTime.add(8);
        processorTime.add(10);
        List<Integer> task = new ArrayList<>();
        task.add(2);
        task.add(2);
        task.add(3);
        task.add(1);
        task.add(8);
        task.add(7);
        task.add(4);
        task.add(5);

        System.out.println(minProcessingTime(processorTime, task));
    }
}
