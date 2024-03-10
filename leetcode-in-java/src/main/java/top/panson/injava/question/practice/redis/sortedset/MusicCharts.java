package top.panson.injava.question.practice.redis.sortedset;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Set;


/**
 * 音乐排行榜
 * @create 2022-05-13 14:09
 * @Author: Panson
 */
public class MusicCharts {
    private Jedis jedis = new Jedis("127.0.0.1");


    /**
     * 添加新的音乐到排行榜中去
     * @param songId
     */
    public void addSong(long songId) {
        jedis.zadd("music_ranking_list", 0, String.valueOf(songId));
    }

    /**
     * 增加歌曲的分数
     */
    public void incrementSongScore(long songId, double score) {
        jedis.zincrby("music_ranking_list", score, String.valueOf(songId));
    }

    /**
     * 获取歌曲在排行榜里的排名
     * @param songId
     * @return
     */
    public long getSongRank(long songId) {
        return jedis.zrevrank("music_ranking_list", String.valueOf(songId));
    }

    /**
     * 获取音乐排行棒
     * @return
     */
    public Set<Tuple> getMusicRankingList() {
        return jedis.zrevrangeWithScores("music_ranking_list", 0, 2);
    }

    public static void main(String[] args) {
        MusicCharts musicCharts = new MusicCharts();
        for (int i = 0; i < 20; i++) {
            musicCharts.addSong(i + 1);
        }
        musicCharts.incrementSongScore(5, 3.2);
        musicCharts.incrementSongScore(15, 5.6);
        musicCharts.incrementSongScore(7, 9.6);

        long songRank = musicCharts.getSongRank(5);
        System.out.println("查看 id 为 5 的歌曲的排名：" + songRank);

        Set<Tuple> musicRankingList = musicCharts.getMusicRankingList();
        System.out.println("查看音乐排行榜排名前三的歌曲： " + musicRankingList);
    }
}
