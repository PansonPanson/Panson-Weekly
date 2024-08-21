
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章


## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/description/)

```java
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        while(right < s.length()) {
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while(valid == need.size()) {
                if(right - left < length) {
                    start = left;
                    length = right - left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);

    }
}
```

+ [567. 字符串的排列](https://leetcode.cn/problems/permutation-in-string/description/)
```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;

        while(right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据更新
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).intValue() == need.get(c).intValue()) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while(right - left >= s1.length()) {
                if(valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)) {
                    if(need.get(d) == window.get(d)) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
```

+ [438. 找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/)
```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while(right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据更新
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).intValue() == need.get(c).intValue()) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while(right - left >= p.length()) {
                if(valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)) {
                    if(need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }
}
```

+ [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/)
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while(window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;

    }
}
```
























