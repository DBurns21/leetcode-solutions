class Solution {
    public boolean doesAliceWin(String s) {

        //Even though yesterdays medium was a bit difficult due to the constraints todays medium is quite easy
        //Due to the way the game is played Bob can't win unless there are no vowels and that's because Alice can't make any moves
        //So all we have to do is just check if the String s contains a vowel
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            //Decided to use a switch case instead since I normally don't and in some cases they are better than if and else if 
            switch(c) {
                case 'a', 'e', 'i', 'o', 'u':
                return true;
            }
        }
        return false;
    }
}