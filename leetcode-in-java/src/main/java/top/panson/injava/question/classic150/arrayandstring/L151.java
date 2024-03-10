package top.panson.injava.question.classic150.arrayandstring;

/**
 * @author Panson
 * @create 2023-12-26
 */
public class L151 {

    static class Solution {
        public static String reverseWords(String s) {
            //
            int head = 0;
            int tail = s.length() - 1;
            StringBuilder stringBuffer = new StringBuilder();
            //
            while(head < tail) {
                if(s.charAt(head) != ' ') {
                    break;
                } else {
                    head++;
                }
            }
            while(head < tail) {
                if(s.charAt(tail) != ' ') {
                    break;
                } else {
                    tail--;
                }
            }
            int i = head;
            int j = tail;
            int blankCount = 0;
            while(i <= j) {
                if(s.charAt(i) == ' ') {
                    blankCount++;
                } else {
                    if(blankCount >= 1) {
                        stringBuffer.append(" ");
                    }
                    stringBuffer.append(s.charAt(i));
                    blankCount = 0;
                }
                i++;
            }

            String removedBlankString = stringBuffer.toString();
            String[] splits = removedBlankString.split(" ");
            StringBuffer ret = new StringBuffer();
            for(int k = splits.length - 1; k >= 0; k--) {
                ret.append(splits[k]);
                if(k != 0) {
                    ret.append(" ");
                }
            }
            return ret.toString();

        }
    }


    public static void main(String[] args) {
        String s = Solution.reverseWords(" the sky is blue ");
        System.out.println(s);
    }
}
