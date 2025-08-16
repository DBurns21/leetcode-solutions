//This took me longer than it should have because I originally thought I had to swap the place of two digits
//but actually I had to just change a single digit
class Solution {
    public int maximum69Number (int num) {
        char[] numChars = String.valueOf(num).toCharArray();
        //after changing this to a char array so I can easily check each digit one by one I just look for the first occurence of a 6
        //once I find it all I have to do is change it to a 9 and then return so I don't change the value of any other 6s
        for (int i = 0; i < numChars.length; ++i) {
            if (numChars[i] == '6') {
                numChars[i] = '9';
                return Integer.parseInt(String.valueOf(numChars));
            }
        }
        //if there happens to be no 6s in the array then I can just return the orignal value of num
        return num;
    }
}