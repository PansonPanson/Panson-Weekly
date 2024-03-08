package top.panson.injava.question.practice.array;

/**
 * @create 2022-08-22 10:36
 * @Author: Panson
 */
public class L1445 {
    static class Solution {
        public static int isPrefixOfWord(String sentence, String searchWord) {
            int sentenceIndex = 0;
            int wordIndex = 0;
            int res = 1;

            while(sentenceIndex < sentence.length()) {
                if(Character.isWhitespace(sentence.charAt(sentenceIndex))) {
                    sentenceIndex++;
                    res++;
                }
                while(sentence.charAt(sentenceIndex) == searchWord.charAt(wordIndex)) {
                    if(wordIndex == searchWord.length() - 1) {
                        return res;
                    }
                    sentenceIndex++;
                    wordIndex++;
                }
                wordIndex = 0;
                while(sentenceIndex < sentence.length() && !Character.isWhitespace(sentence.charAt(sentenceIndex))) {
                    sentenceIndex++;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            int prefixOfWord = isPrefixOfWord("dumb dream duck duck i", "dream");
            System.out.println(prefixOfWord);
        }
    }
}
