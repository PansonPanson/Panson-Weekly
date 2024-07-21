
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


+ [1314. 矩阵区域和](https://leetcode.cn/problems/matrix-block-sum/description/)
```java
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] presum = new int[m][n];
        int[][] answer = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    presum[i][j] = mat[i][j];
                } else if(i == 0) {
                    presum[i][j] = mat[i][j] + presum[i][j - 1];
                } else if(j == 0) {
                    presum[i][j] = mat[i][j] + presum[i - 1][j];
                } else {
                    presum[i][j] = mat[i][j] + presum[i - 1][j]  + presum[i][j - 1] - presum[i - 1][j - 1];
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                if(r1 > 0  && c1 > 0) {
                    answer[i][j] = presum[r2][c2] - presum[r1 - 1][c2] - presum[r2][c1 - 1] + presum[r1 - 1][c1 - 1];
                } else if(r1 > 0){
                    answer[i][j] = presum[r2][c2] - presum[r1 - 1][c2];
                } else if(c1 > 0) {
                    answer[i][j] = presum[r2][c2] - presum[r2][c1 - 1];
                } else {
                    answer[i][j] = presum[r2][c2];
                }
            }
        }
        return answer;
    }
}
```

+ [724. 寻找数组的中心下标](https://leetcode.cn/problems/find-pivot-index/description/)
```java
class Solution {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        if(preSum[nums.length - 1] - nums[0] == 0) {
            return 0;
        }
        for(int i = 1; i < nums.length; i++) {
            if(preSum[i - 1] * 2 == preSum[nums.length - 1] - nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
```

























