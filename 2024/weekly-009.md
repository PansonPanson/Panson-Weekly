

*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+ 

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [167. 两数之和 II - 输入有序数组](https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/)

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right +1};
            }
            if(numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}

```

+ [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/description/)

```java

class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                max = Math.max(max, (right - left) * height[left++]);
            } else {
                max = Math.max(max, (right - left) * height[right--]);
            }
        }
        return max;      
    }
}
```


+ [15. 三数之和](https://leetcode.cn/problems/3sum/description/)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> newArray = Arrays.asList(nums[i], nums[j], nums[k]);
                    String str = "" + nums[i] + nums[j] + nums[k];
                    if(!set.contains(str)) {
                        ret.add(newArray);
                        set.add(str);
                    }

                    j++;
                    k--;
                } else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ret;
    }
}
```

+ [904. 水果成篮](https://leetcode.cn/problems/fruit-into-baskets/description/)

```java
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if(n <= 2) {
            return n;
        }
        int left = 0;
        int max = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < n; i++) {
            count.put(fruits[i], count.getOrDefault(fruits[i], 0) + 1);
            while(count.size() > 2) {
                count.put(fruits[left], count.get(fruits[left]) - 1);
                if(count.get(fruits[left]) == 0) {
                    count.remove(fruits[left]);
                }
                left++;
            } 
            max = Math.max(max, i - left + 1);
        } 
        return max;
    }
}
```


+ [209. 长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum/)
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ret = Integer.MAX_VALUE;;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < n) {
            sum += nums[right];
            while(sum >= target) {
                ret = Math.min(ret, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
} 
```

+ [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                // 如果遇到重复的字符，则移动左边界
                left = Math.max(map.get(s.charAt(i)) + 1, left);
                
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
```

+ [739. 每日温度](https://leetcode.cn/problems/daily-temperatures/description/)
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer topIndex = stack.pop();
                ret[topIndex] = i - topIndex;
            }
            // 此时，单调栈中的元素全都比当前遍历元素大了
            stack.push(i);
        }
        return ret;
    }
}
```

+ [36. 有效的数独](https://leetcode.cn/problems/valid-sudoku/description/)
```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        Map<Integer, Set<Integer>> area = new HashMap<>();
         for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }

        for(int i  = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if(ch == '.') {
                    continue;
                }
                int val = Integer.valueOf(ch);
                if(row.get(i).contains(val)) {
                    return false;
                } else {
                    row.get(i).add(val);
                }

                if(col.get(j).contains(val)) {
                    return false;
                } else {
                    col.get(j).add(val);
                }
                int areaIndex = i / 3 * 3 + j / 3;
                if(area.get(areaIndex).contains(val)) {
                    return false;
                } else {
                    area.get(areaIndex).add(val);
                }
            }
        }
        return true;


    }
}
```










