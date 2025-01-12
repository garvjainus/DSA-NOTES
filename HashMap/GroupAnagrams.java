class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String, ArrayList<String>> output = new HashMap<String, ArrayList<String>>();
        for(String s: strs){
            char[] x = s.toCharArray();
            Arrays.sort(x);
            String in = String.valueOf(x);
            if(!output.containsKey(in)){
                output.put(in, new ArrayList<String>());
            }
            output.get(in).add(s);
        }
        ArrayList<List<String>> y = new ArrayList<>();
        for(String s: output.keySet()){
            y.add(output.get(s));;
        }
        return y;
    }
}