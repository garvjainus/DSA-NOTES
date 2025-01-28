// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    Integer[][] d2p;
    public int maxProfit2(int[] lengths, int[] prices, int rodLength){
        int[][] dp = new int[prices.length + 1][rodLength + 1];
        for(int i = 0; i <= prices.length; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i <= prices.length; i++){
            for(int j = 1; j <= rodLength; j++){
                if(j < lengths[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], prices[i-1] + dp[i][j-lengths[i-1]]);
                }
            }
        }
        return dp[prices.length][rodLength];
    }
    
    public int maxProfit(int[] lengths, int[] prices, int rodLength){
        d2p = new Integer[prices.length + 1][rodLength + 1];
        for(int i = 0; i <= prices.length; i++){
            d2p[i][0] = 0;
        }
        return recursive(lengths, prices, rodLength, 0);
    }
    
    public int recursive(int[] lengths, int[] prices, int rodLength, int i){
        if(rodLength <= 0 || i >= lengths.length){
            return 0;
        }
        
        if(d2p[i][rodLength] != null){
            return d2p[i][rodLength];
        }
        
        int possibility1;
        if(rodLength - lengths[i] >= 0){
            possibility1 = prices[i] + recursive(lengths, prices, rodLength - lengths[i], i);
        } else {
            possibility1 = Integer.MIN_VALUE;
        }
        int possibility2 = recursive(lengths, prices, rodLength, i + 1);
        
        int result = Math.max(possibility1, possibility2);
        d2p[i][rodLength] = result;
        return result;
    }
    /*
    recursive
    poss2 = recursive(1)
    
    0
    poss1 = 3 + recursive (0)
    poss1 = 3 + recurisve(0)
    poss1 = 3 + recursive(0)
    
    */
    public static void main(String[] args){
        int[] l = {1,2,3,4,5};
        int[] p = {2,6,7,10,13};
        Main x = new Main();
        System.out.println(x.maxProfit2(l,p,5));
    }
}