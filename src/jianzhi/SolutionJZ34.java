package jianzhi;

/**
 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
//未完成
class SolutionJZ34 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }
    public static int FirstNotRepeatingChar(String str) {
        int[]  res=new int[52];
        for (int i=0;i<52;i++){
            res[i]=-1;
        }
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int index1 = getIndex(c);
            if(res[index1]==-1){
                res[index1]=i;
            }else{
                res[index1]=52+res[index1];
            }
        }
        for(int i=0;i<52;i++){
            if(res[i]<52 && res[i]>-1){
                return res[i];
            }
        }
        return 0;
    }

    private static int getIndex(char c){
        if(c<='z'&& c>='a'){
            return  c-'a';
        }else{
            return c-'A'+26;
        }
    }
}
