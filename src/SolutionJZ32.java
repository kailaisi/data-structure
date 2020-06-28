import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 解题思路：
 * 如果要找到最小值，那么直接排序即可。
 * 问题的关键是怎么比较大小呢？肯定不是a和b来比较。
 * 这里需要比较ab  vs  ba   拼接之后的字符串
 * 排序应该是ab vs  ba  如果ab<ba   那么  a<b
 */
public class SolutionJZ32 {
    public static void main(String[] args) {
        int[] ints = new int[3];
        ints[0] = 3;
        ints[1] = 32;
        ints[2] = 321;
        System.out.println(PrintMinNumber(ints));
    }

    public static String PrintMinNumber(int[] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] =numbers[i]+"";
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
        }
        return builder.toString();
    }
}