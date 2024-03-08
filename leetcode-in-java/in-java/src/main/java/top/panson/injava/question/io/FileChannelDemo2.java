package top.panson.injava.question.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * FileChannel 是多线程并发安全的
 * @create 2022-06-15 20:24
 * @Author: Panson
 */
public class FileChannelDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("/Users/panson/Documents/project/github/leetcode-in-java" +
                "/in-java/src/main/java/top/panson/injava/question/io/test2.md");
        FileChannel channel = in.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(15);
        // 读数据写入 buffer, 写完之后 buffer 的position = 16
        channel.read(buffer);
        System.out.println(channel.position());
        buffer.flip();
        byte[] data = new byte[15];
        buffer.get(data);

        System.out.println(data.length);
        System.out.println(new String(data));
        System.out.print("[");
        for(int i = 0; i < data.length; i++) {
            System.out.print((char)data[i]);
        }
        System.out.println("]");
    }

}

