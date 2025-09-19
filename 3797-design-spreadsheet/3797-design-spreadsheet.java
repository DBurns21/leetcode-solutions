class Spreadsheet {
    int[][] spreadsheet;

    public Spreadsheet(int rows) {
        spreadsheet = new int[26][rows];
        
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;

        spreadsheet[col][row] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;

        spreadsheet[col][row] = 0;
    }
    
    public int getValue(String formula) {
        //This works for if you have to check for different operations but in this case there will only be +
        //String[] words = formula.split("((?<==)|(?==)|(?<=\\+)|(?=\\+)|(?<=-)|(?=-)|(?<=/)|(?=/)|(?<=\\*)|(?=\\*))");
        String[] words = formula.split("\\+|=");
        int one = 0;
        int two = 0;

        String currWord = words[1];
        if (Character.isLetter(currWord.charAt(0))) {
            //Since the letters will always be capital we can subtract 'A' from it so that it starts from 0
            //if lowercase was added then we just make currWord.charAt(0) set to uppoercase (or lowercase isntead and subtract 'a' instead)
            int col = currWord.charAt(0) - 'A';
            int row = Integer.parseInt(currWord.substring(1)) - 1;

            one = spreadsheet[col][row];
        }
        else {
            one = Integer.parseInt(currWord);
        }

        currWord = words[2];
        if (Character.isLetter(currWord.charAt(0))) {
            int col = currWord.charAt(0) - 'A';
            int row = Integer.parseInt(currWord.substring(1)) - 1;

            two = spreadsheet[col][row];
        }
        else {
            two = Integer.parseInt(currWord);
        }

        //Orignally I thought I had to check if the formula had a + - * or / but apparently it is always just +
        return one + two;
        /*
        switch (words[2].charAt(0)) {
            case '+':
                return one + two;
            case '-':
                return one - two;
            case '/':
                return one / two;
            default:
                return one * two;
        }
        */
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */