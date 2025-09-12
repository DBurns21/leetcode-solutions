class Solution {
    public boolean doesAliceWin(String s) {
        ArrayList<Integer> locations = new ArrayList<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
                //locations.add(i);
            }
        }

        int size = locations.size();
        String remaining = s;
        while (true) {
            if (size == 0) {
                return false;
            }
            else if (size % 2 == 0) {
                locations.subList(0, size-2).clear();
            }
            else {
                locations.subList(0, size-1).clear();
            }

            size = locations.size();

            if (size <= 1) {
                return true;
            }
            else if (size % 2 == 0) {
                locations.subList(0, size-1).clear();
            }
            else {
                locations.subList(0, size-2).clear();
            }

            size = locations.size();
        }
        
    }
}