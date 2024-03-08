package top.panson.injava.question.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @create 2022-06-15 20:00
 * @Author: Panson
 */
public class FileChannelDemo {

    public static void main(String[] args) throws IOException {
        // 构造一个传统的文件输出流
        FileOutputStream out = new FileOutputStream("/Users/panson/Documents/project/github/" +
                "leetcode-in-java/in-java/src/main/java/top/panson/injava/question/io/test.md");
        // 通过文件输出流获取到对应的FileChannel，以 NIO 的方式来写文件
        FileChannel channel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.wrap("hello word".getBytes(StandardCharsets.UTF_8));
        // 把  buffer 的数据写入到 channel
        // channel 必然会从 buffer 的position = 0 的位置开始读起，一直读到 limit, limit = 字符串字节数组的长度
        // buffer 的 position 是不是就已经变成了跟limit 一样了
        channel.write(buffer);
        System.out.println(buffer.position());
        // 当前写到了文件的哪一个位置
        System.out.println(channel.position());
        // 复位
        buffer.rewind();
        channel.position(5);
        channel.write(buffer);
        channel.close();
        out.close();
    }
}
