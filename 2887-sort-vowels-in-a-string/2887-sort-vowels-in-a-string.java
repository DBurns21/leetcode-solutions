//The problem today is a simple one but it has a slight twist that makes it difficult
//The switch is it needs to be fairly efficient in order to pass the testcases
class Solution {
    public String sortVowels(String s) { 
        //AEIOUaeiou (order of vowels)
        int[] freq = new int[10];
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            char lowercase = Character.toLowerCase(c);

            //orignally I had insertion sort which is fine for smaller cases but with a complexity of n^2 large cases take too long
            //since there are only 10 possible vowels I went with bucket sort and collected the frequency of each vowel in order to be more efficient
            //while better this is still one of the slower algorithms that is able to pass all of the test cases
            if (lowercase == 'a' || lowercase == 'e' || lowercase == 'i' || lowercase == 'o' || lowercase == 'u') {
               
                if (c == 'A') {
                    freq[0]++;
                }
                else if (c == 'E') {
                    freq[1]++;
                }
                else if (c == 'I') {
                    freq[2]++;
                }
                else if (c == 'O') {
                    freq[3]++;
                }
                else if (c == 'U') {
                    freq[4]++;
                }
                else if (c == 'a') {
                    freq[5]++;
                }
                else if (c == 'e') {
                    freq[6]++;
                }
                else if (c == 'i') {
                    freq[7]++;
                }
                else if (c == 'o') {
                    freq[8]++;
                }
                else {
                    freq[9]++;
                }
            }
        }
        
        
        for (int i = 0; i < freq.length; ++i) {
            System.out.println(freq[i]);
        }
        
        

        String newString =  "";
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            char lowercase = Character.toLowerCase(c);
            if (lowercase == 'a' || lowercase == 'e' || lowercase == 'i' || lowercase == 'o' || lowercase == 'u') {
                
                if (freq[0] != 0) {
                    newString += 'A';
                    freq[0]--;
                }
                else if (freq[1] != 0) {
                    newString += 'E';
                    freq[1]--;
                }
                else if (freq[2] != 0) {
                    newString += 'I';
                    freq[2]--;
                }
                else if (freq[3] != 0) {
                    newString += 'O';
                    freq[3]--;
                }
                else if (freq[4] != 0) {
                    newString += 'U';
                    freq[4]--;
                }
                else if (freq[5] != 0) {
                    newString += 'a';
                    freq[5]--;
                }
                else if (freq[6] != 0) {
                    newString += 'e';
                    freq[6]--;
                }
                else if (freq[7] != 0) {
                    newString += 'i';
                    freq[7]--;
                }
                else if (freq[8] != 0) {
                    newString += 'o';
                    freq[8]--;
                }
                else {
                    newString += 'u';
                }
            }
            else {
                newString += c;
            }
        }

        return newString;
    }
}