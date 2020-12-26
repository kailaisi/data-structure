package leetcode;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
class SolutionLT67 {
    public static void main(String[] args) {
        SolutionLT67 lt = new SolutionLT67();
        System.out.println(lt.addBinary("11", "1"));
        System.out.println(lt.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int alen = a.length()-1;
        int blen = b.length()-1;
        int cary = 0;
        StringBuilder builder = new StringBuilder();
        int num;
        while (alen >= 0 && blen >= 0) {//根据共同的长度进行处理
            num = 0;
            num += a.charAt(alen--) - '0';
            num += b.charAt(blen--) - '0';
            num += cary;
            builder.append(num % 2);
            cary = num / 2;
        }
        while (alen>=0){//a超长
            num = 0;
            num += a.charAt(alen--) - '0';
            num += cary;
            builder.append(num % 2);
            cary = num / 2;
        }
        while (blen>=0){//b超长
            num = 0;
            num += b.charAt(blen--) - '0';
            num += cary;
            builder.append(num % 2);
            cary = num / 2;
        }
        if (cary == 1) {//最后一位
            builder.append(1);
        }
        return builder.reverse().toString();
    }
}