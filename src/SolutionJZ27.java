import java.util.ArrayList;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 知识点：字符串，动态规划，递归
 * 解题思路：未完成
 */
public class SolutionJZ27 {
    public static void main(String[] args) {
        ArrayList<String> list = Permutation("abc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static ArrayList<String> Permutation(String str) {
        // TODO: 2020/6/26  
        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 0) {
            return list;
        }
        if (str.length() == 1) {
            list.add(str);
            return list;
        }
        String substring = str.substring(0, 2);
        char[] chars = substring.toCharArray();
        if (str.length() == 2) {
            list.add(substring);
            list.add(String.valueOf(chars[1]) + chars[0]);
            return list;
        } else {
            str.
            for(int i=0;i<str.length();i++){
                Permutation(str.substring(i))
            }
            //字母放到首位
            ArrayList<String> stringArrayList = Permutation(str.substring(1, str.length() - 1));
            for (int i = 0; i < stringArrayList.size(); i++) {
                list.add(chars[0] + stringArrayList.get(i));
            }
            //字母放到末尾
            stringArrayList = Permutation(str.substring(0, str.length() - 1));
            for (int i = 0; i < stringArrayList.size(); i++) {
                list.add(stringArrayList.get(i) + str.substring(str.length() - 1));
            }
        }
        return list;
    }
}