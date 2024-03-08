package top.panson.injava.question.practice.redis.sortedset;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import javax.naming.directory.SearchResult;
import java.util.Set;

/**
 * 新闻浏览案例
 * @create 2022-05-13 15:05
 * @Author: Panson
 */
public class NewsDemo {

    private Jedis jedis = new Jedis("127.0.0.1");

    /**
     * 加入一篇新闻
     * @param newsId
     */
    public void addNews(long newsId, long timestamp) {
        jedis.zadd("news", timestamp, String.valueOf(newsId));
    }

    /**
     * 分页搜索新闻
     * @param maxTimeStamp
     * @param minTimeStamp
     * @param index
     * @param count
     * @return
     */
    public Set<Tuple> searchNews(long maxTimeStamp, long minTimeStamp, int index, int count) {
        return jedis.zrevrangeByScoreWithScores("news", maxTimeStamp, minTimeStamp, index, count);
    }

    public static void main(String[] args) {
        NewsDemo demo = new NewsDemo();

        for(int i = 0; i < 20; i++) {
            demo.addNews(i + 1, i + 1);
        }

        long maxTimestamp = 18;
        long minTimestamp = 2;

        int pageSize = 10;
        int startIndex = 0;

        Set<Tuple> searchResult = demo.searchNews(
                maxTimestamp, minTimestamp, startIndex, pageSize);

        System.out.println("搜索指定时间范围内的新闻的第一页：" + searchResult);
    }
}
