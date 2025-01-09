/*
delimiter is space

*/
import java.util.ArrayList;
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> digit = new ArrayList<String>();
        ArrayList<String> letter = new ArrayList<String>();
        for(String s: logs){
            String[] s1 = s.split(" ");
            if (Character.isDigit(s1[1].charAt(0))) {
                digit.add(s);
            } else {
                letter.add(s);
            }
        }
        String[] letterArray = letter.toArray(new String[0]);
        Arrays.sort(letterArray, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            int cmp = split1[1].compareTo(split2[1]);
            if (cmp != 0) {
                return cmp; 
            }
            return split1[0].compareTo(split2[0]); 
        });

        int j = 0;
        for(String s: letterArray){
            logs[j++] = s;
        }
        for(String s: digit){
            logs[j] = s;
            j++;
        }
        return logs;
    }
}