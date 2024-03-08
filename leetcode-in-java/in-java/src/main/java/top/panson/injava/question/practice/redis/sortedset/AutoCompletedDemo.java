package top.panson.injava.question.practice.redis.sortedset;

import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.Set;

/**
 * @create 2022-05-28 20:49
 * @Author: Panson
 */
public class AutoCompletedDemo {

    private static Jedis jedis = new Jedis("127.0.0.1");


    public static void main(String[] args) {
        AutoCompletedDemo demo = new AutoCompletedDemo();

        jedis.flushAll();
        demo.search("我爱大家");
        demo.search("我喜欢学习Redis");
        demo.search("我很喜欢一个城市");
        demo.search("我不太喜欢玩儿");
        demo.search("我喜欢学习Spark");

        Set<String> autoCompleteList = demo.getAotoCompleteList("我");
        System.out.println("第一次自动补全推荐：" + autoCompleteList);


        Set<String> autoCompleteList2 = demo.getAotoCompleteList("我喜");
        System.out.println("第二次自动补全推荐：" + autoCompleteList2);


    }

    private void search(String keyword) {
        StringBuffer potentialKeyWord = new StringBuffer();

        for(char ch : keyword.toCharArray()) {
            potentialKeyWord.append(ch);
            jedis.zincrby("potential_keyword::" + potentialKeyWord + "::keywords",
                    new Date().getTime(),
                    keyword);
        }
    }

    private Set<String> getAotoCompleteList(String potentialKeyWord) {

        return jedis.zrevrange("potential_keyword::" + potentialKeyWord + "::keywords", 0, 2);
    }
}
