import java.util.ArrayList;
class Solution {
    private List<String> output;

    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12){
            return new ArrayList<String>();
        }
        output = new ArrayList<>();

        backtrack(0,0,"",s);
        return output;
    }
    public void backtrack(int i, int dots, String ip, String s){
        if(dots == 4 && i == s.length()){
            output.add(ip.substring(0, ip.length() -1));
            return;
        }
        if(dots > 4 || i > s.length()){
            return;
        }
        for(int j = i; j < Math.min(s.length(), i + 3); j++){
            String str = s.substring(i, j+1);
            int val = Integer.parseInt(str);
            if(val < 256){
                if(str.length() > 1 && str.charAt(0) != '0'){
                    backtrack(j + 1, dots + 1, ip + str + ".", s);
                } else if (str.length() == 1){
                    backtrack(j + 1, dots + 1, ip + str + ".", s);
                }
            }
        }
    }
}