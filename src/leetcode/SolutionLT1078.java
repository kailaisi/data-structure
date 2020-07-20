package leetcode;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

/**
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * 示例 1：
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * 示例 2：
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 * 提示：
 * 1 <= text.length <= 1000
 * text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
 * 1 <= first.length, second.length <= 10
 * first 和 second 由小写英文字母组成
 */
class SolutionLT1078 {
    // TODO: 2020/7/20 待验证
    public static void main(String[] args) {
        SolutionLT1078 lt1078 = new SolutionLT1078();
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        String[] ocurrences = lt1078.findOcurrences(text, first, second);
        for (String s:ocurrences){
            System.out.println(s);
        }
    }

    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> list = new ArrayList<>();
        String regex = first + " " + second;
        String[] split = text.split(regex);
        for (String str : split) {
            list.add(str.replace(regex, ""));
            String[] s = str.split(" ");
            if (s.length > 0) {
                list.add(s[0]);
            }
        }
        String[] strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i);
        }
        return strings;
    }
}