class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> vowels = new HashMap<>();
        Map<Character, Integer> consonants = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            switch(c) {
                case 'a', 'e', 'i', 'o', 'u':
                vowels.put(c, vowels.getOrDefault(c, 0) + 1);
                break;
                default: 
                consonants.put(c, consonants.getOrDefault(c, 0) + 1);
            }
        }

        int vowelFreq = 0;
        for (int value : vowels.values()) {
            if (value > vowelFreq) {
                vowelFreq = value;
            }
        }

        int consonantFreq = 0;
        for (int value : consonants.values()) {
            if (value > consonantFreq) {
                consonantFreq = value;
            }
        }
        System.out.println("Vowels: " + vowelFreq + "\nConsonatns: " + consonantFreq);
        return vowelFreq + consonantFreq;
    }
}