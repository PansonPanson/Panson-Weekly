package top.panson.injava.question.interviewfromnet;

import java.util.HashSet;
import java.util.Set;

/**
 * 拼多多一面面经
 * 岗位：服务端开发
 * 部门：做拼多多海外版Temu的
 *
 * 1. 自我介绍
 * 2. 分别介绍一下简历上三个项目自己担任什么角色，负责了哪些部分
 * 3. 科研课题我主要做了哪些事，怎么实现的，目前进展到什么程度了，对尚未解决的问题有什么解决思路吗
 * 4. Gradle插件是怎么写的
 * 5. 数据库有涉及到吗，索引是什么数据结构，索引是不是越多越好？为什么？
 * 6. 算法题：1-9这九个数字，写成三个三位数，不能有重复数字，第二个数是第一个数的二倍，第三个数是第一个数的三倍，例如327，654，981，输出这三个数。
 * 先给大概3分钟想一下思路，和面试官交流，思路是回溯，问怎么剪枝，一开始没啥思路，后面在引导下，就是锁定回溯的起始位置和终止为止，然后每遍历到一个三位数就看看它的二倍和三倍有没有重复数字，如果有就剪枝（但我觉得这不算剪枝......感觉是运算逻辑），只给15分钟写代码，最后没有A出来
 * pdd的这个oj平台有点逆天，自己不能运行，也没有那些编译报错的提醒（分号都不提醒），完全一个白板，最后面试官给运行，debug的时候真的巨尴尬，这里少个分号，那里语法有点错误，很考察代码基本功
 *
 * 总结：pdd是很看算法的，算法A出来就差不多可以过，没A大概率是凉的，所以xdm面pdd之前一定要好好刷算法！！！
 *
 * 4.25更新：流程终止，pdd真的看算法，秋招刷够300题再战
 *
 *
 * 作者：我脑子不好
 * 链接：https://www.nowcoder.com/feed/main/detail/564786e2eef743f6a179314de0c4fee3
 * 来源：牛客网
 *
 *
 * @author Panson
 * @create 2023-10-12
 */
public class N001 {

    public static class Solution {

        public static void main(String[] args) {

            long start = System.currentTimeMillis();
            for(int i = 100; i < 329; i++) {
                for(int j = 2 * i; j < 658; j++) {
                    for(int k = 3 * i; k < 987; k++) {
                        if(j ==  i * 2 && k == i * 3  && right(i, j, k)) {
                            System.out.println(i + "  " + j + "  " + k);

                        }
                    }
                }
            }
            System.out.println(System.currentTimeMillis() - start);
        }
    }

    public static boolean right(int i, int j, int k) {
        Set<Character> set = new HashSet<>();
        String iString = String.valueOf(i);
        String jString = String.valueOf(j);
        String kString = String.valueOf(k);
        for(int n = 0; n < 3; n++) {
            set.add(iString.charAt(n));
            set.add(jString.charAt(n));
            set.add(kString.charAt(n));
        }
        return set.size() == 9;
    }


}
