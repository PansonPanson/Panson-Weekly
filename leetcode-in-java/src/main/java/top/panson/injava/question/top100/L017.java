package top.panson.injava.question.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * @create 2022-01-13 21:57
 * @Author: Panson
 */
public class L017 {
//    private static Map<Integer, String> letterMap = new HashMap<>();
    private static String[] letterMap = new String[]{
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
//    private static Map<Integer, String> buildLetterMap() {
//        letterMap.put(0, " ");
//        letterMap.put(1, "");
//        letterMap.put(2, "abc");
//        letterMap.put(3, "def");
//        letterMap.put(4, "ghi");
//        letterMap.put(5, "jkl");
//        letterMap.put(6, "mno");
//        letterMap.put(7, "pqrs");
//        letterMap.put(8, "tuv");
//        letterMap.put(9, "wxyz");
//        return letterMap;
//    }

    private static ArrayList<String> res;

    public static List<String> letterCombinations(String digits) {
//        letterMap = buildLetterMap();

        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    /**
     * 利用递归回溯，类似于构建一个三叉树，深度遍历，等价于穷举对应的路径
     * @param digits
     * @param index
     * @param s
     */
    private static void findCombination(String digits, int index, String s){

        if(index == digits.length()){
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];  // "abc" -> "def"
        for(int i = 0 ; i < letters.length() ; i++){
            findCombination(digits, index+1, s + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23" ));
    }

}
