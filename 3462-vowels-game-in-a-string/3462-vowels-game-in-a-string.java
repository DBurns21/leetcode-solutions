class Solution {
    public boolean doesAliceWin(String s) {
        ArrayList<Integer> locations = new ArrayList<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                locations.add(i);
            }
        }

        int size = locations.size();
        String remaining = s;
        while (remaining.length() > 0) {
            if (size == 0) {
                return false;
            }
            else if (size % 2 == 0) {
                //remaining = s.substring(s.length() - remaining.length(), locations.get(size-2));
                locations.subList(0, size-2).clear();
            }
            else {
                //remaining = s.substring(s.length() - remaining.length(), locations.get(size));
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
        return false;
    }
}