import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class SolutionJZ33 {
    public int GetUglyNumber_Solution(int index) {
        if(index<7){
            return index;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int p2=0,p3=0,p5=0;
        while (list.size()<index){
            int m2 = list.get(p2) * 2;
            int m3 = list.get(p3) * 3;
            int m5 = list.get(p5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if(min==m2) p2++;
            if(min==m3) p3++;
            if(min==m5) p5++;
        }
        return  list.get(index-1);
    }

    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return c - 'A' + 26;
        }
    }
}