import array.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 知识点：字符串，动态规划，递归
 * 解题思路：未完成
 */
public class SolutionJZ27 {
    public static void main(String[] args) {
        ArrayList<String> list = Permutation("abcd");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        if (str.length() == 1) {
            list.add(str);
            return list;
        }
        find(str.toCharArray(),0,list);
        Collections.sort(list);
        return  list;
    }

    private static void find(char[] ch, int index, ArrayList<String> lists) {
        if(index==ch.length-1){
            if(!lists.contains(new String(ch))){
                lists.add(new String(ch));
                return;
            }
        }else{
            for (int j=index;j<ch.length;j++){
                swap(ch,index,j);
                find(ch,index+1,lists);
                swap(ch,index,j);
            }
        }
    }

    private static void swap(char[] ch, int index, int j) {
        char temp=ch[index];
        ch[index]=ch[j];
        ch[j]=temp;
    }
}