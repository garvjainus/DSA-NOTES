class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> chillguy = new HashSet<>();
        for(char cancer: jewels.toCharArray()){
            chillguy.add(cancer);
        }
        int count = 0;
        for(char omegagyat: stones.toCharArray()){
            if(chillguy.contains(omegagyat)){
                count++;
            }
        }
        return count;
    }
}