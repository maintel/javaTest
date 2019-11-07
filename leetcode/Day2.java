package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Maintel
 * @create 2019-11-08 0:57
 **/
public class Day2 {

    public static void main(String[] args) {
        String test = "tvqnkvovks";
        String s = "";
        System.out.println(String.valueOf(" ".charAt(0)));
        System.out.println("".equals(s));
        System.out.println(" ".equals(s));
//        System.out.println(longsString2(test));
        StringBuilder stringBuffer = new StringBuilder();
        System.out.println(stringBuffer.indexOf("1"));
    }

    /*
    解法一，挨个查询以某个字符开始的字符串，并存储起来，然后再对比是否有重复的，如果有重复的则从这个字符的下一个字符开始继续查询，直到查询完整个字符串
     */
    public static int longsString1(String s) {
        if (s == null) {
            return 0;
        }
        if ("".equals(s)) {
            return 0;
        }
        StringBuffer stringBuffer = new StringBuffer(s);  // 参考方法二，在这里如果不使用 stringbuffer 而直接使用 s 则速度更快，内存小号更小 64 ms	37.1 MB
        Map<String, String> stringMap = new HashMap<>();
        int startItem = 0;
        int longs = 0;
        for (int i = startItem; i < stringBuffer.length(); i++) {
            String item = String.valueOf(stringBuffer.charAt(i));
            if (stringMap.get(item) == null) {
                stringMap.putIfAbsent(item, item);
            } else {
                i = startItem;
                startItem++;
                //比较上一个字符串的长度 和当前字符串长度
                if (longs < stringMap.size()) {
                    longs = stringMap.size();
                }
                // 如果查找出的字符串的长度已经大于剩余的所有字符串了，则直接返回
                if (longs >= stringBuffer.length() - startItem) {
                    break;
                }
                stringMap.clear();
            }
        }

        if (longs == 0 || longs < stringMap.size()) {
            longs = stringMap.size();
        }
        return longs;
    }

//    public static int longsString2(String s) {
//        if (s == null || "".equals(s)) {
//            return 0;
//        }
//
//        int longs = 0;
//        String lastStr = "";
//        String[] strings = new String[s.length()];
//        Map<String, String> longsMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            String item = String.valueOf(s.charAt(i));
//            if (longsMap.get(item) != null) {
//                if (longs < longsMap.size())
//                    longs = longsMap.size();
//                if (lastStr.equals(item)) {
//                    longsMap.clear();
//                    strings = new String[s.length()];
//                } else {
//                    //tvqnkvovks
//                    for (String removeItem :
//                            strings) {
//                        if (removeItem == null) {
//                            continue;
//                        }
//                        if (removeItem.equals(item)) {
//                            strings = new String[s.length()];
//                            break;
//                        } else {
//                            longsMap.remove(removeItem);
//                        }
//                    }
//                }
//            }
//            strings[i] = item;
//            lastStr = item;
//            longsMap.putIfAbsent(item, item);
//
//        }
//
//        if (longs == 0 || longs < longsMap.size()) {
//            longs = longsMap.size();
//        }
//        return longs;
//    }


}
