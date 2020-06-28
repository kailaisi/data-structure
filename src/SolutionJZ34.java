/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class SolutionJZ34 {
    public int FirstNotRepeatingChar(String str) {
        int[] chars = new int[52];
        for (int i = 0; i < str.length(); i++) {
            int index = getIndex(str.charAt(i));
            chars[index] = chars[index] + 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (chars[getIndex(str.charAt(i))] == 1) {
                return i;
            }
        }
        return 0;
    }

    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return c - 'A' + 26;
        }
    }
}