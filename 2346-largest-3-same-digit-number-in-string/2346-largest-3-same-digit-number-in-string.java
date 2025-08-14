class Solution {
    public String largestGoodInteger(String num) {
        //origanally I checked if the string was less than 3 but in the constraints the shortest length of n is 3 so I removed it
        String substring = "";

        //I go through all but the last 2 digits and check if the current digit is equal to the two after it and if it is I check if the substring has been updated
        //if it hasn't been updated I update the current substring into it but if it has I check if it has a larger value than the substring.
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