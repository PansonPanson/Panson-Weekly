



*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+ 

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)
+ [13. 罗马数字转整数](https://leetcode.cn/problems/roman-to-integer/description/)

```java

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int n = s.length();
        int pre = map.get(s.charAt(0));
        int ret = 0;
        for(int i = 1; i < n; i++) {
            int cur = map.get(s.charAt(i));
            // 当小值在大值的左边，则减小值，如 IV=5-1=4；
            if(pre < cur) {
                ret -= pre;
            } else {
                ret += pre;
            }
            pre = cur;
        }
        ret += pre;
        return ret;
    }
}
```

+ [12. 整数转罗马数字](https://leetcode.cn/problems/integer-to-roman/)

```java
class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int n = values.length;
        StringBuffer ret = new StringBuffer();
        for(int i = 0; i < n; i++) {
            int value = values[i];
            String str = strs[i];
            while(num >= value) {
                num -= value;
                ret.append(str);
            }
            if(num == 0) {
                break;
            }
        }
        return ret.toString();
    }
}
```


+ [58. 最后一个单词的长度](https://leetcode.cn/problems/length-of-last-word/)

```java

class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == ' ' && i >= 0) {
            i--;
        }

        int ret = 0;
        while(i >= 0 &&s.charAt(i) != ' ') {
            ret++;
            i--;
        }
        return ret;
    }
}

```


+ [14. 最长公共前缀](https://leetcode.cn/problems/longest-common-prefix/)

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0) {
            return "";
        }
        if(n == 1) {
            return strs[0];
        }

        int ret = 0;

        for(int i = 0; i < strs[0].length(); i++) {
            char cur = strs[0].charAt(i);

            for(int j = 1; j < n; j++) {
                if(ret < i || strs[j].length() - 1 < i || cur != strs[j].charAt(i)) {
                    break;
                }
                if(j == n - 1) {
                    ret++;
                }
            }
        }
        return strs[0].substring(0, ret);
    }
}
```

+ [151. 反转字符串中的单词](https://leetcode.cn/problems/reverse-words-in-a-string/description/)

```java
class Solution {
    public String reverseWords(String s) {
        //
        int head = 0;
        int tail = s.length() - 1;
        StringBuilder stringBuffer = new StringBuilder();
        //
        while(head < tail) {
            if(s.charAt(head) != ' ') {
                break;
            } else {
                head++;
            }
        }
        while(head < tail) {
            if(s.charAt(tail) != ' ') {
                break;
            } else {
                tail--;
            }
        }
        int i = head;
        int j = tail;
        int blankCount = 0;
        while(i <= j) {
            if(s.charAt(i) == ' ') {
                blankCount++;
            } else {
                if(blankCount >= 1) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(s.charAt(i));
                blankCount = 0;
            }
            i++;
        }

        String removedBlankString = stringBuffer.toString();
        String[] splits = removedBlankString.split(" ");
        StringBuffer ret = new StringBuffer();
        for(int k = splits.length - 1; k >= 0; k--) {
            ret.append(splits[k]);
            if(k != 0) {
                ret.append(" ");
            }
        }
        return ret.toString();

    }
}
```


+ [6. N 字形变换](https://leetcode.cn/problems/zigzag-conversion/description/)

```java
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        List<StringBuilder> ret = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            ret.add(new StringBuilder());
        }

        int flag = -1;
        int i = 0;
        int count = 0;
        while(count < s.length()) {
            if(i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            ret.get(i).append(s.charAt(count));
            i += flag;
            count++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int j = 0; j < numRows; j++) {
            stringBuilder.append(ret.get(j));
        }
        return stringBuilder.toString();

    }
}
```

+ [28找出字符串中第一个匹配项的下标](https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/)

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i = 0; i <= n - m; i++) {
            int a = i;
            int b = 0;
            while(b < m && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            if(b == m) {
                return i;
            }
        }
        return -1;
    }
}
```
