class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            //since this problem was very easy the only way to make it "harder" was find a way to optimize it which there is not a lot of room to do so
            //but instead of checking if the whole string is equals you only need to check at most two character because either the first or 
            //second character will tell you if you are adding or subtracting
            if (operation.contains("+")) {
                x++;
            }
            else {
                x--;
            }
        }

        return x;
    }
}