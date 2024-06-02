
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [26. 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int p1= 0; 
        int p2 = 0;
        while(p2 < n) {
            // 找到第一个
            while(p2 < n && nums[p1] == nums[p2]) {
                p2++;
            }
            p1++;
            if(p2 < n) {
                nums[p1] = nums[p2];
            }
        }
        return p1;
    }
}
```


```java
/**
 * 用队列实现一个栈
 *
 * @author Panson
 * @create 2024-05-31
 */
public class Queue2Stack<T> {

    private Deque<T> queue;

    private Deque<T> tmpQueue;

    public Queue2Stack() {
        queue = new ArrayDeque<>();
        tmpQueue = new ArrayDeque<>();
    }

    public void push(T element) {
        queue.offer(element);
    }

    public T pop() {
        if(isEmpty()) {
             throw new RuntimeException("Queue2Stack is empty");
        }
        while(queue.size() > 1) {
            tmpQueue.offer(queue.poll());
        }
        T element = queue.poll();
        Deque<T> tmp = tmpQueue;
        tmpQueue = queue;
        queue = tmp;
        return element;
    }

    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue2Stack is empty");
        }
        while(queue.size() > 1) {
            tmpQueue.offer(queue.poll());
        }
        T element = queue.poll();
        tmpQueue.offer(element);
        Deque<T> tmp = tmpQueue;
        tmpQueue = queue;
        queue = tmp;
        return element;
    }


    public boolean isEmpty() {
        return queue.isEmpty();
    }

}

```

```java
/**
 * 如何用栈实现一个队列
 * @author Panson
 * @create 2024-05-31
 */
public class Stack2Queue<T> {

    private Deque<T> stackA;

    private Deque<T> stackB;

    public Stack2Queue() {
        stackA = new ArrayDeque<>();
        stackB = new ArrayDeque<>();
    }

    public boolean isEmpty() {
        return stackA.isEmpty();
    }

    public void offer(T element) {
        stackA.push(element);
    }

    public T pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack2Queue is empty");
        }
        if(stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException("Stack2Queue is empty");
        }
        if(isEmpty()) {
            throw new RuntimeException("Stack2Queue is empty");
        }
        if(stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }
}
```





















