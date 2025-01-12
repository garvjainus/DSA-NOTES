class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        StringBuilder gyat = new StringBuilder();
        while(p1>=0 || p2>=0){
            int x1 = p1>=0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2>=0 ? num2.charAt(p2) - '0' : 0;
            int val = (x1 + x2 + carry)%10;
            carry = (x1+x2+carry)/10;
            p1--;
            p2--;
            gyat.append(val);
        }

        if(carry != 0){
            gyat.append(carry);
        }
        return gyat.reverse().toString();
    }
}