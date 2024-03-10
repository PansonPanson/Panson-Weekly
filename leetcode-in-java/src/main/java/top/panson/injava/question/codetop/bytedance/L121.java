package top.panson.injava.question.codetop.bytedance;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @create 2022-06-10 11:27
 * @Author: Panson
 */
public class L121 {

    class Solution {
        public int maxProfit(int[] prices) {
            // 利用  minPrice 维护 dp 数组， dp[i]表示截止到i，价格的最低点是多少
            int maxProfit = Integer.MIN_VALUE;
            int minPrice = Integer.MAX_VALUE;
            for(int price : prices) {
                if(price < minPrice) {
                    minPrice = price;
                } else if(price - minPrice > maxProfit) {
                    maxProfit = price - minPrice;
                }
            }
            return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
        }
    }

    class Solution1 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            // dp 存储第 i 天出售或者购买的最大利润
            // int[][] dp = new int[n][2];
            int dpi0 = 0;
            int dpi1 = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                int tmp = dpi0;
                dpi0 = Math.max(dpi0, dpi1 + prices[i]);
                dpi1 = Math.max(dpi1, dpi0 - prices[i]);
            }
            return dpi0;
        }
    }


    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1L);
        student.setName("A");
        List<Student> students = new ArrayList<>();
        students.add(student);
        List<Student> newStudents = students.stream().filter(a -> a.getName().equals("A")).collect(Collectors.toList());
        student.setName("B");
        System.out.printf(JSON.toJSONString(newStudents));
    }
}
