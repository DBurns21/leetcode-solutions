class Solution {
    public int maximum69Number (int num) {
        char[] numChars = String.valueOf(num).toCharArray();

        for (int i = 0; i < numChars.length; ++i) {
            if (numChars[i] == '6') {
                numChars[i] = '9';
                return Integer.parseInt(String.valueOf(numChars));
            }
        }

        return num;
    }
}