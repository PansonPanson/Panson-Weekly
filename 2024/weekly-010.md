

*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+ 

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/description/)
```java

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix.length == 0) {
            return ret;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int index = 0;
        while(true) {
            for(int i = left; i <= right; i++) {
                ret.add(matrix[top][i]);
                index++;
            }
            if(++top > bottom) {
                break;
            }
            for(int i = top; i <= bottom; i++) {
                ret.add(matrix[i][right]);
                index++;
            }
            if(left > --right) {
                break;
            }
            for(int i = right; i >= left; i--) {
                ret.add(matrix[bottom][i]);
                index++;
            }
            if(--bottom < top) {
                break;
            }
            for(int i = bottom; i >= top; i--) {
                ret.add(matrix[i][left]);
                index++;
            }
            if(++left > right) {
                break;
            }
        }
        return ret;

    }
}
```

+ [48. 旋转图像](https://leetcode.cn/problems/rotate-image/description/)

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }

        for(int k = 0; k < n; k++) {
            for(int l = k + 1; l < n; l++) {
                int tmp1 = matrix[k][l];
                matrix[k][l] = matrix[l][k];
                matrix[l][k] = tmp1;
            }
        }

    }
} 
```


+ [73. 矩阵置零](https://leetcode.cn/problems/set-matrix-zeroes/)

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n  = matrix[0].length;
        // 首行标记，默认为 1，表示不置零
        int r0 = 1;
        // 首列标记，默认为 1，表示不置零
        int c0 = 1;
        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) {
                r0 = 0;
                break;
            }
        }
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                c0 = 0;
                break;
            }
        }
        // 将首行首列作为备忘录
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // 遍历第一行，如果有 0，该列置零
        for(int j = 1; j < n; j++) {
            if(matrix[0][j] == 0) {
                // 首行有元素被标记为 1，该列整列被置为 0
                for(int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 从第一行开始
        for(int i = 1; i < m; i++) {
            // 首列有元素被标记为 1， 该行整行被置为 0
            if(matrix[i][0] == 0) {
                for(int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        

        if(r0 == 0) {
            for(int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if(c0 == 0) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
```

+ [383. 赎金信](https://leetcode.cn/problems/ransom-note/description/)

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countMem = new int[26];
        for(char c : magazine.toCharArray()) {
            countMem[c -'a'] += 1;
        }
        for(char c1 : ransomNote.toCharArray()) {
            if(countMem[c1 - 'a'] <= 0) {
                return false;
            }
            countMem[c1 - 'a'] -= 1;
        }
        return true;
    }
}
```
+ [205. 同构字符串](https://leetcode.cn/problems/isomorphic-strings/description/)
```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(s2t.containsKey(sch) && s2t.get(sch) != tch || t2s.containsKey(tch) && t2s.get(tch) != sch) {
                return false;
            }
            s2t.put(sch, tch);
            t2s.put(tch, sch);
        }
        return true;

    }
}
```

+ [290. 单词规律](https://leetcode.cn/problems/word-pattern/description/)
```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if(pattern.length() != split.length) {
            return false;
        }
        Map<Character, String> a2b = new HashMap<>();
        Map<String, Character> b2a = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String str = split[i];
            if(a2b.containsKey(ch) && !a2b.get(ch).equals(str) || b2a.containsKey(str) && !b2a.get(str).equals(ch)) {
                return false;
            }
            a2b.put(ch, str);
            b2a.put(str, ch);
        }
        return true;
    }
}

```

+ [242. 有效的字母异位词](https://leetcode.cn/problems/valid-anagram/description/)
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if(l1 != l2) {
            return false;
        }
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for(int i = 0; i < l1; i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(sCount.containsKey(sch)) {
                sCount.put(s.charAt(i), sCount.get(sch) + 1);
            } else {
                sCount.put(s.charAt(i), 1);
            }
            if(tCount.containsKey(t.charAt(i))) {
                tCount.put(t.charAt(i), tCount.get(tch) + 1);
            } else {
                tCount.put(t.charAt(i), 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : sCount.entrySet()) {
            if(!entry.getValue().equals(tCount.get(entry.getKey()))) {
                return false;
            }
        }
        return true;

    }
}
```


+ [43. 字符串相乘](https://leetcode.cn/problems/multiply-strings/description/)
```java

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String strSort = new String(chs);
            if(map.containsKey(strSort)) {
                map.get(strSort).add(str);
            } else {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(strSort, arr);
            }
        }
        return new ArrayList<>(map.values());
    }
}
```

+ [1. 两数之和](https://leetcode.cn/problems/two-sum/description/)
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -2};
    }
}
```











