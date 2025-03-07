package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-07
 */
public class L134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for(int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if(sum < 0) {
            return -1;
        }

        sum = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if(sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return start;

    }
}
