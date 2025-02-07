import java.util.*;
import java.util.stream.*;

/*

*/


class Solution {
    public static int lcsLengthRec(String s1, String s2, int i, int j, int count) {
        // base case of when either string has been exhausted
        if (i >= s1.length() || j >= s2.length()) {
            return count;
        }
        // if i and j characters match, increment the count and compare the rest of the strings
        if (s1.charAt(i) == s2.charAt(j)) {
            count = lcsLengthRec(s1, s2, i + 1, j + 1, count + 1);
        }
        // compare s1[i:] with s2, s1 with s2[j:], and take max of current count and these two results
        return Math.max(count, Math.max(lcsLengthRec(s1, s2, i + 1, j, 0), lcsLengthRec(s1, s2, i, j + 1, 0)));
    }

    public static int lcsLength(String s1, String s2) {
        return lcsLengthRec(s1, s2, 0, 0, 0);
    }

    // Driver code
    public static void main(String[] args) {
        String[] s1 = {
            "bcdcdcd",
            "arefun",
            "yourocks",
            "abc"
        };
        String[] s2 = {
         
            "aacdcdcd",
            "isfun",
            "youawesome",
            "def"
        };

        // You can uncomment the lines below and check how this recursive solution causes a time-out 
        // String temp1[] = Arrays.copyOf(s1, s1.length + 1); 
        // temp1[s1.length] = "ypzrvyigwdiqrnbglvviozqzruvmwivgvqvrfhqi";
        // s1 = temp1;

        // String temp2[] = Arrays.copyOf(s2, s2.length + 1); 
        // temp2[s2.length] = "wdiqrnbglvviozqzruvmwivgvqvrfhqiypzrvyigwdiqrn";
        // s2 = temp2;

        for (int i = 0; i < s1.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string 1: \"" + s1[i] + "\"");
            System.out.println("\tInput string 2: \"" + s2[i] + "\"");
            System.out.println("\n\tThe Length of Longest Common Substring is: " + lcsLength(s1[i], s2[i]));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }

    }
    
s1 = "abcde";
s2 = "bce";


  // table for tabulation of size m x n
        int dp[][] = new int[m + 1][n + 1];
        for (int[] row: dp) {
            Arrays.fill(row, 0);
        }



import java.util.*;
import java.util.stream.*;

class Solution {
    public static int lcsLength(String s1, String s2) {
        int m = s1.length(); // length of s1
        int n = s2.length(); // length of s2

        // table for tabulation of size m x n
        int dp[][] = new int[m + 1][n + 1];
        for (int[] row: dp) {
            Arrays.fill(row, 0);
        }

        int maxLength = 0; // to keep track of longest substring seen 

        for (int i = 1; i < m + 1; i++) { // iterating to fill table
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) { // if characters at this position match, 
                    dp[i][j] = dp[i - 1][j - 1] + 1; // add 1 to the previous diagonal and store it in this diagonal
                    maxLength = Math.max(maxLength, dp[i][j]); // if this substring is longer, update maxLength
                } else
                    dp[i][j] = 0; // if character don't match, common substring size is 0
            }
        }
        return maxLength;
    }

    // Driver code
    public static void main(String[] args) {
        String[] s1 = {
         
            "bcdcdcd",
            "arefun",
            "yourocks",
            "abc"
        };
        String[] s2 = {
            "aacdcdcd",
            "isfun",
            "youawesome",
            "def"
        };

        // Let's uncomment this to see the benefit of using dynamic programming with tabulation
        // String temp1[] = Arrays.copyOf(s1, s1.length + 1); 
        // temp1[s1.length] = "ypzrvyigwdiqrnbglvviozqzruvmwivgvqvrfhqi";
        // s1 = temp1;

        // String temp2[] = Arrays.copyOf(s2, s2.length + 1); 
        // temp2[s2.length] = "wdiqrnbglvviozqzruvmwivgvqvrfhqiypzrvyigwdiqrn";
        // s2 = temp2;

        for (int i = 0; i < s1.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string 1: \"" + s1[i] + "\"");
            System.out.println("\tInput string 2: \"" + s2[i] + "\"");
            System.out.println("\n\tThe Length of Longest Common Substring is: " + lcsLength(s1[i], s2[i]));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }

    }

}
    
    
    