
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [151. 反转字符串中的单词](https://leetcode.cn/problems/reverse-words-in-a-string/description/)
```java
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int r = s.length() - 1;
        int l = r;
        StringBuilder str = new StringBuilder();
        while (l >= 0) {
            while (l >= 0 && s.charAt(l) != ' ') {
                l--;
            }
            str.append(s.substring(l + 1, r + 1)).append(" ");
            while (l >= 0 && s.charAt(l) == ' ') {
                l--;
            }
            r = l;
        }
        return str.toString().trim();
    }
}


```

+ [48. 旋转图像](https://leetcode.cn/problems/rotate-image/description/)
```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 对角线翻转
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 翻转每一行
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}
```

+ [54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/description/)




















