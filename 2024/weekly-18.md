
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [187. 重复的DNA序列](https://leetcode.cn/problems/repeated-dna-sequences/description/)

```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n  = s.length();
        Map<String, Integer> count = new HashMap<>();
        List<String> ret = new ArrayList<>();
        for(int i= 0; i + 10 <= n; i++) {
            String cur = s.substring(i, i + 10);
            Integer curCount = count.getOrDefault(cur, 0);
            if(curCount == 1) {
                ret.add(cur);
            } 
            count.put(cur, curCount + 1);
        }
        return ret;
    }
}


```




















