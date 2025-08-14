class Solution {
    public String largestGoodInteger(String num) {
        if (num.length() < 3) {
            return "";
        }
        String substring = "";
        for (int i = 0; i < num.length() - 2; ++i) {
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
                if (substring.length() == 0 || (Integer.parseInt(substring) < Integer.parseInt(num.substring(i, i+3)))) {
                    substring = num.substring(i, i+3);
                }
                
            }
        }
        return substring;
    }
}