class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        ArrayList<Character> chars = new ArrayList<>();
        int maxSize = 0;
        
        for (int i = 0; i < s.length()-1; ++i) {
            chars.clear();
            for (int j = i; j < s.length(); ++j) {
                if (chars.contains(s.charAt(j))) {
                    break;
                }
                
                chars.add(s.charAt(j));
            }
            if (maxSize < chars.size()) {
                maxSize = chars.size();
            }
        }
        

        return maxSize;
    }
}