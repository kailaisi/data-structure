package leetcode;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 *
 * 解题思路：每个字符都是上一个字符的描述，所以只要找到d[n-1]->d[n]的变化规律即可。可以使用递归方式
 * 观察结果：下一个数据，都是上一个数据的同一个数字，然后进行分组。
 * eg:111221的下一个数字    1出现了3次，所以是31    2出现了2次，说以是22    1出现了1次，所以是11
 * 综合起来就是：312211
 *
 */
class SolutionLT38 {
    public static void main(String[] args) {
        SolutionLT38 lt = new SolutionLT38();
        System.out.println(lt.countAndSay(1));
        System.out.println(lt.countAndSay(2));
        System.out.println(lt.countAndSay(3));
        System.out.println(lt.countAndSay(4));
        System.out.println(lt.countAndSay(5));
        System.out.println(lt.countAndSay(30));
    }

    public String countAndSay(int n) {
        if(n<=0){
            return "";
        }
        if(n==1){
            return "1";
        }
        String res="11";
        for(int i=3;i<=n;i++){
            res=count(res);
        }
        return res;
    }

    public String count(String n){
        StringBuilder builder = new StringBuilder();
        int len=n.length();
        int num=n.charAt(0)-'0';
        int count=1;
        for(int i=1;i<n.length();i++){
            if(n.charAt(i)==n.charAt(i-1)){
                count++;
            }else{
                builder.append(count).append(num);
                num=n.charAt(i)-'0';
                count=1;
            }
            if(i==len-1){
                builder.append(count).append(num);
            }
        }
        return builder.toString();

    }
}