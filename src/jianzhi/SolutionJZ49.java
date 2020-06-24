package jianzhi;

public class SolutionJZ49 {
    public int StrToInt(String str) {
        if(str.isEmpty()){
            return 0;
        }
        int d=0;
        boolean first=true;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(i==0){
                if(c=='+'){
                    continue;
                }else if(c=='-'){
                    first=false;
                    continue;
                }
            }
            if(c<'9'&&c>'0'){
                d=(d*10+(c-'0'));
            }else{
                return 0;
            }
        }
        if(!first){
            d=0-d;
        }
        return  d;
    }
}