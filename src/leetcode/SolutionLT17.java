package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 提示：0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 思路：这就是一个不断迭代组装数据的问题。
 */
class SolutionLT17 {

    public static void main(String[] args) {
        SolutionLT17 lt = new SolutionLT17();
        System.out.println(lt.letterCombinations("23"));
        System.out.println(lt.letterCombinations(""));
        System.out.println(lt.letterCombinations("2"));
    }


    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        letter(list, digits);
        return list;
    }

    private void letter(ArrayList<String> list, String digits) {
        if (digits.isEmpty()) {
            return;
        }
        int num = digits.charAt(0) - '0';
        String[] list1 = getList(num);
        if (list.isEmpty()) {
            for (String s : list1) {
                list.add(s);
            }
        } else {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String remove = list.remove(0);
                for (String s : list1) {
                    list.add(remove + s);
                }
            }
        }
        letter(list, digits.substring(1));
    }

    private String[] getList(int num) {
        switch (num) {
            case 2:
                return new String[]{"a", "b", "c"};
            case 3:
                return new String[]{"d", "e", "f"};
            case 4:
                return new String[]{"g", "h", "i"};
            case 5:
                return new String[]{"j", "k", "l"};
            case 6:
                return new String[]{"m", "n", "o"};
            case 7:
                return new String[]{"p", "q", "r", "s"};
            case 8:
                return new String[]{"t", "u", "v"};
            case 9:
                return new String[]{"w", "x", "y", "z"};
            default:
                return new String[]{};
        }
    }
}