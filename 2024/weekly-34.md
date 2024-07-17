
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)
+ [303. 区域和检索 - 数组不可变](https://leetcode.cn/problems/range-sum-query-immutable/description/)
```java
class NumArray {

    int[] numsMemory;

    public NumArray(int[] nums) {
        numsMemory = new int[nums.length];
        numsMemory[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            numsMemory[i] = nums[i] + numsMemory[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if(left > right) {
            return 0;
        }
        if(left == 0) {
            return numsMemory[right];
        }
        return numsMemory[right] - numsMemory[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */ 
```



+ [304. 二维区域和检索 - 矩阵不可变](https://leetcode.cn/problems/range-sum-query-2d-immutable/description/)
```java
class NumMatrix {

    int[][] numsMemory;
    public NumMatrix(int[][] matrix) {
        numsMemory = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i == 0 && j == 0) {
                    numsMemory[i][j] = matrix[i][j];
                } else if(i == 0) {
                    numsMemory[i][j] = matrix[i][j] + numsMemory[i][j - 1];
                } else if(j == 0) {
                    numsMemory[i][j] = matrix[i][j] + numsMemory[i - 1][j];
                } else {
                    numsMemory[i][j] = matrix[i][j] + numsMemory[i - 1][j] + numsMemory[i][j - 1] - numsMemory[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) {
            return numsMemory[row2][col2];
        }
        if(row1 == 0) {
            return numsMemory[row2][col2] - numsMemory[row2][col1 - 1];
        }

        if(col1 == 0) {
            return numsMemory[row2][col2] - numsMemory[row1 - 1][col2];
        }
        return numsMemory[row2][col2] - numsMemory[row2][col1 - 1] - numsMemory[row1 - 1][col2] + numsMemory[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
```

+ [1081. 不同字符的最小子序列](https://leetcode.cn/problems/smallest-subsequence-of-distinct-characters/description/)
```java
class Solution {
    public String smallestSubsequence(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] exist = new boolean[255];
        int[] count = new int[255];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            count[cur]--;
            if(exist[cur]) {
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > cur) {
                if(count[stack.peek()] == 0) {
                    break;
                }
                exist[stack.pop()] = false;
            }
            stack.push(cur);
            exist[cur] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }
} 
```
























