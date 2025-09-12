class Solution {
    public boolean doesAliceWin(String s) {

        //Even though yesterdays medium was a bit difficult due to the constraints todays medium is quite easy
        //Due to the way the game is played Bob can't win unless there are no vowels and that's because Alice can't make any moves
        //So all we have to do is just check if the String s contains a vowel
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }

        return false;
        
    }
}