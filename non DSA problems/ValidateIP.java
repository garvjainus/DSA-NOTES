/*
*/
class Solution {
    public String validIPAddress(String queryIP) {
        String[] v4 = queryIP.split("\\.", -1);
        String[] v6 = queryIP.split("\\:", -1);
        boolean ipv4 = false;
        boolean ipv6 = false;
        System.out.println(v4.length);
        if(v4.length == 4){
            for (String segment : v4) {
                if (segment.length() == 0 || segment.length() > 3) {
                    return "Neither";
                }
                if (segment.length() > 1 && segment.charAt(0) == '0') {
                    return "Neither";
                }
                for (char c : segment.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return "Neither";
                    }
                }
                int num = Integer.parseInt(segment);
                if (num < 0 || num > 255) {
                    return "Neither";
                }
            }
            ipv4 = true;
        } else if (v6.length == 8){
            for(int i = 0; i < v6.length; i++){
                if(v6[i].length() > 4 || v6[i].length() == 0){
                    xeturn "Neither";
                } 
                for(int j = 0; j < v6[i].length(); j++){
                    if(!Character.toString(v6[i].charAt(j)).matches("[0-9a-fA-F]")) {
                       return "Neither";
                    }
                }
            }
            ipv6 = true;
        } 
        if(ipv6){
            return "IPv6";
        } else if(ipv4){
            return "IPv4";
        }
        return "Neither";
    }
}