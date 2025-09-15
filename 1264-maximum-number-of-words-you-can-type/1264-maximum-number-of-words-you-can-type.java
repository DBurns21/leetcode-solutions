class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] strings = text.split(" ");
        ArrayList<String> stringsList = new ArrayList<>(Arrays.asList(strings));
        int words = stringsList.size();

        for (int i = 0; i < brokenLetters.length(); ++i) {
            char c = brokenLetters.charAt(i);
            
            for (int j = 0; j < stringsList.size(); ++j) {
                if (stringsList.get(j).indexOf(c) != -1) {
                    words--;
                    stringsList.remove(j);
                    j--;
                }
            }
            if (words == 0) {
                return 0;
            }
        }

        return words;
    }
}