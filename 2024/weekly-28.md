
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [27. 移除元素](https://leetcode.cn/problems/remove-element/description/)
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }

        int p1 = 0;
        int p2 = 0;

        int n = nums.length;
        while(p2 <= n - 1) {
            while(p2 <= n - 1 && nums[p2] == val) {
                p2++;
            }
            if(p2 <= n - 1) {
                nums[p1] = nums[p2];
                p1++;
                p2++;
            }
        }
        return p1;
    }
} 
```


+ [283. 移动零](https://leetcode.cn/problems/move-zeroes/description/)
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int p1 = 0;
        int p2 = 0;
        while(p2 <= n - 1) {
            while(p2 <= n - 1 && nums[p2] == 0) {
                p2++;
            }
            if(p2 <= n - 1) {
                nums[p1] = nums[p2];
                p1++;
                p2++;
            }
        }
        while(p1 <= n - 1) {
            nums[p1++] = 0;
        }
    }
} 
```


+ [344. 反转字符串](https://leetcode.cn/problems/reverse-string/description/)
```java
class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int p1 = 0;
        int p2 = n - 1;
        while(p1 < p2) {
            char tmp = s[p1];
            s[p1] = s[p2];
            s[p2] = tmp;
            p1++;
            p2--;
        }
    }
} 
```





















