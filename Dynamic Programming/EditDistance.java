class Solution {
    public int minDistance(String word1, String word2) {

        Integer[][] dp = new Integer[word1.length() + 1][word2.length() + 1];
        return minDistanceRec(word1,word2,0,0, dp);
    }
    public int minDistanceRec(String w1, String w2, int i, int j, Integer[][] dp ){
        if(i >= w1.length()){
            return w2.length() - j;
        } else if (j >= w2.length()){
            return w1.length() - i;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(w1.charAt(i) == w2.charAt(j)){
            return minDistanceRec(w1,w2,i+1,j+1, dp);
        }

        int insert = 1 + minDistanceRec(w1,w2,i,j+1, dp);
        int remove = 1 + minDistanceRec(w1,w2,i+1,j, dp);
        int replace = 1 + minDistanceRec(w1,w2,i+1,j+1, dp );

        int val = Math.min(insert, Math.min(remove,replace));

        dp[i][j] = val;
        return val;
    }
}