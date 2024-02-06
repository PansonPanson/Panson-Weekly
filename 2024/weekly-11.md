

*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+ 

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)


+ [202. 快乐数](https://leetcode.cn/problems/happy-number/description/)
```java
class Solution {
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
         int sum = 0;
        while(!set.contains(n)) {
            set.add(n);
            while(n > 0) {
                int remain = n % 10;
                n = n / 10;
                sum += Math.pow(remain, 2);
            }
            if(sum == 1) {
                return true;
            } 
            n = sum;
            sum = 0;
        }
        return false;
    }
}
```


+ [219. 存在重复元素 II](https://leetcode.cn/problems/contains-duplicate-ii/description/)
```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])  && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
```

+ [128. 最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/description/)

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> allNums = new HashSet<>();
        for(int num : nums) {
            allNums.add(num);
        }
        int ret = 0;
        for(int num : allNums) {
            if(allNums.contains(num - 1)) {
                continue;
            }
            int start = num;
            int length = 1;
            while(allNums.contains(start + 1)) {
                start += 1;
                length += 1;
            }
            ret = Math.max(length, ret);
        }
        return ret;
    }
} 
```

+ []()
```java
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if(nums.length == 0) {
            return ret;
        }
        if(nums.length == 1) {
            ret.add(Integer.toString(nums[0]));
            return ret;
        }
        int i = 0;
        while(i < nums.length) {
            int start = i;
            i++;
            while(i < nums.length && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int end = i - 1;
            if(start < end) {
                ret.add(nums[start] + "->" + nums[end]);
            } else {
                ret.add(Integer.toString(nums[start]));
            }
        }
        return ret;
    }
}
```

+ [56. 合并区间](https://leetcode.cn/problems/merge-intervals/description/)
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ret = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while(i < intervals.length) {
            int start = i;
            i++;
            while(i < intervals.length && intervals[i - 1][1] >= intervals[i][0]) {
                intervals[i][0] = Math.min(intervals[i][0], intervals[i - 1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
                i++;
            }
            int end = i - 1;
            int[] arr = new int[2];
            arr[0] = intervals[start][0];
            arr[1] = intervals[end][1];
            ret.add(arr);
        }
        return ret.toArray(new int[ret.size()][]);
    }
} 
```

+[57. 插入区间](https://leetcode.cn/problems/insert-interval/description/)

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;                    
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}

```











