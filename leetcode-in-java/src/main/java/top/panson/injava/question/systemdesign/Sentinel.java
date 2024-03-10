package top.panson.injava.question.systemdesign;

/**
 * 使用 Redis 实现分布式限流
 * http://svip.iocoder.cn/Redis/Interview/#Redis-%E6%98%AF%E5%8D%95%E7%BA%BF%E7%A8%8B%E7%9A%84%EF%BC%8C%E5%A6%82%E4%BD%95%E6%8F%90%E9%AB%98%E5%A4%9A%E6%A0%B8-CPU-%E7%9A%84%E5%88%A9%E7%94%A8%E7%8E%87%EF%BC%9F
 *
 * @create 2022-03-21 16:47
 * @Author: Panson
 */
public class Sentinel {

//    public boolean isActionAllowed(String userId, String actionKey, int period,
//                                   int maxCount) {
//        String key = String.format("hist:%s:%s", userId, actionKey); // 使用用户编号 + 行为作为 KEY 。这样，我们就可以统计某个用户的操作行为。
//        long nowTs = System.currentTimeMillis(); // 获取当前时间。
//        Pipeline pipe = jedis.pipelined(); // pipeline 批量操作，提升效率。
//        pipe.multi(); // 此处启动了事务，可以保证指令的原子性。
//        pipe.zadd(key, nowTs, "" + nowTs); // zset 添加，key value score 要看下。
//        pipe.zremrangeByScore(key, 0, nowTs - (period * 1000)); // zremrangeByScore ，移除超过周期的 value 。
//
//        Response<Long> count = pipe.zcard(key); // zcard ，计算 zset 的数量
//        pipe.expire(key, period + 1); // 设置过期。这里多 + 1 秒，为了防止网络延迟。
//        pipe.exec(); // pipeline 执行
//        pipe.close();
//
//        return count.get() <= maxCount; // 是否超过最大次数。
//    }
}
