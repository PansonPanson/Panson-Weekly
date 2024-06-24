
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [752. 打开转盘锁](https://leetcode.cn/problems/open-the-lock/description/)
```java
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadLocks = new HashSet<>();
        for(String str : deadends) {
            deadLocks.add(str);
        }
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();

        int step = 0;
        queue.offer("0000");
        visited.add("0000");
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String cur = queue.poll();
                if(deadLocks.contains(cur)) {
                    continue;
                }
                if(target.equals(cur)) {
                    return step;
                }

                for(int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if(!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if(!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String plusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if(ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    public String minusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if(ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
} 
```























