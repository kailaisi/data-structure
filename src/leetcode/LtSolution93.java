package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *  
 * 示例:
 * <p>
 * 输入: "2552551115"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
class LtSolution93 {

    public static void main(String[] args) {
        LtSolution93 so = new LtSolution93();
        List<String> list = so.restoreIpAddresses("2552551115");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }

    ArrayList<String> list = new ArrayList<>();
    int[] segment = new int[4];

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return list;
    }

    private void dfs(String s, int pointNum, int start) {
        if (pointNum == 4) {
            if (start == s.length()) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    builder.append(segment[i]);
                    if (i != 3) {
                        builder.append(".");
                    }
                }
                list.add(builder.toString());
            }
            return;
        }
        if (start == s.length()) {
            return;
        }
        if (s.charAt(start) == '0') {
            segment[pointNum] = 0;
            dfs(s, pointNum + 1, start + 1);
        } else {
            for (int i = start + 1; i <= s.length() && i < start + 4; i++) {
                int num = Integer.parseInt(s.substring(start, i));
                if (num < 256) {
                    segment[pointNum] = num;
                    dfs(s, pointNum + 1, i);
                }
            }
        }
    }
}
