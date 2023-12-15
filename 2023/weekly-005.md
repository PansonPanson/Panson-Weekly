
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章

+ [得物商品状态体系介绍](https://mp.weixin.qq.com/s/TqXMtS44D4w6d1-KLxcoiQ)

## 1.2 泛互联网文章




# 2 技术总结

## 2.1 Redis 源码阅读 —— sds 结构体源码阅读

![](https://raw.githubusercontent.com/PansonPanson/blog-pic-2023/main/2023/202311241835437.png)

```c
/* Note: sdshdr5 is never used, we just access the flags byte directly.
 * However is here to document the layout of type 5 SDS strings. */
struct __attribute__ ((__packed__)) sdshdr5 {
    unsigned char flags; /* 3 lsb of type, and 5 msb of string length */
    char buf[];
};
struct __attribute__ ((__packed__)) sdshdr8 {
    uint8_t len; /* used */
    uint8_t alloc; /* excluding the header and null terminator */
    unsigned char flags; /* 3 lsb of type, 5 unused bits */
    char buf[];
};
struct __attribute__ ((__packed__)) sdshdr16 {
    uint16_t len; /* used */
    uint16_t alloc; /* excluding the header and null terminator */
    unsigned char flags; /* 3 lsb of type, 5 unused bits */
    char buf[];
};
struct __attribute__ ((__packed__)) sdshdr32 {
    uint32_t len; /* used */
    uint32_t alloc; /* excluding the header and null terminator */
    unsigned char flags; /* 3 lsb of type, 5 unused bits */
    char buf[];
};
struct __attribute__ ((__packed__)) sdshdr64 {
    uint64_t len; /* used */
    uint64_t alloc; /* excluding the header and null terminator */
    unsigned char flags; /* 3 lsb of type, 5 unused bits */
    char buf[];
};
```



在 Redis 中，设计了 5 个 sds 结构体，用于存储不同长度的字符串。设计 5 个不同的结构体，主要是出于节约存储的目的，比如说用  sdshdr8 就能存下的字符串，如果用 sdshdr64 存储，那就是 8 倍的存储空间消耗，对于一家稍微上体量的互联网公司，可能是过百亿级别的数据量，单就字符串存储上就要多耗费 70GB 的内存。由此可见，Redis 在数据结构上是做了诸多设计优化的。

字段注释：

```c
struct __attribute__ ((__packed__)) sdshdr8 {
  	// buf 数组已使用字节数
    uint8_t len;   
  	// buf 数组总共分配的字节数
    uint8_t alloc;  
  	// 低三位用于表示字符串类型
    unsigned char flags;
  	// 用于存储字符串的真实数据
    char buf[];          
};
```



在结构体上使用 `__attribute__ ((__packed__))` 指定 ，可以强制不进行内存对齐。这样的话，sds 就可以通过指针移动来便捷地读取值。在 sds 的结构体中，flags 一共 8 位，其中低 3 位用于表示 sds 类型， sds 类型如下：

```c
#define SDS_TYPE_5  0
#define SDS_TYPE_8  1
#define SDS_TYPE_16 2
#define SDS_TYPE_32 3
#define SDS_TYPE_64 4
#define SDS_TYPE_MASK 7
#define SDS_TYPE_BITS 3
#define SDS_HDR_VAR(T,s) struct sdshdr##T *sh = (void*)((s)-(sizeof(struct sdshdr##T)));
#define SDS_HDR(T,s) ((struct sdshdr##T *)((s)-(sizeof(struct sdshdr##T))))
#define SDS_TYPE_5_LEN(f) ((f)>>SDS_TYPE_BITS)

static inline size_t sdslen(const sds s) {
    unsigned char flags = s[-1];
    switch(flags&SDS_TYPE_MASK) {
        case SDS_TYPE_5:
            return SDS_TYPE_5_LEN(flags);
        case SDS_TYPE_8:
            return SDS_HDR(8,s)->len;
        case SDS_TYPE_16:
            return SDS_HDR(16,s)->len;
        case SDS_TYPE_32:
            return SDS_HDR(32,s)->len;
        case SDS_TYPE_64:
            return SDS_HDR(64,s)->len;
    }
    return 0;
}
```





# 3 Algorithm(算法题)

+ [380. O(1) 时间插入、删除和获取随机元素](https://leetcode.cn/problems/insert-delete-getrandom-o1/)

```java
class RandomizedSet {

        private Map<Integer, Integer> val2IndexMap;
        private List<Integer> vals;
        private Random random;

        public RandomizedSet() {
            val2IndexMap = new HashMap<>();
            vals = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if(val2IndexMap.containsKey(val)) {
                return false;
            }
            vals.add(val);
            val2IndexMap.put(val, vals.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if(!val2IndexMap.containsKey(val)) {
                return false;
            }
            Integer needDeleteValIndex = val2IndexMap.get(val);
            int lastVal = vals.get(vals.size() - 1);
            vals.set(needDeleteValIndex, lastVal);
            vals.remove(vals.size() - 1);
            val2IndexMap.put(lastVal, needDeleteValIndex);
            val2IndexMap.remove(val);
            return true;
        }

        public int getRandom() {
            int randomIndex = random.nextInt(vals.size());
            return vals.get(randomIndex);
        }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```



