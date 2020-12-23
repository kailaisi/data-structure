package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * 题解：
 */
class SolutionLT387 {
    public static void main(String[] args) {
        SolutionLT387 lt = new SolutionLT387();
        System.out.println(lt.firstUniqChar("leetcode"));
        System.out.println(lt.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        if (s.isEmpty()) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if(map.containsKey(key)){
                map.put(key,-1);
            }else{
                map.put(key,i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.get(key)!=-1){
                return i;
            }
        }
        return -1;
    }
}