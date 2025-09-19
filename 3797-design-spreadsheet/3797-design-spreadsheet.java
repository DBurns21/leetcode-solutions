class Spreadsheet {
    int[][] spreadsheet;

    public Spreadsheet(int rows) {
        spreadsheet = new int[26][rows];
        
    }
    
    public void setCell(String cell, int value) {
        System.out.print("setting cell at ");
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        System.out.println("col: " + col + " row: " + row + " to " + value);

        spreadsheet[col][row] = value;
    }
    
    public void resetCell(String cell) {
        System.out.print("reseting cell ");
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        System.out.println("for col: " + col + " row: " + row);

        spreadsheet[col][row] = 0;
    }
    
    public int getValue(String formula) {
        System.out.println("getting value for " + formula);
        String[] words = formula.split("((?<==)|(?==)|(?<=\\+)|(?=\\+)|(?<=-)|(?=-)|(?<=/)|(?=/)|(?<=\\*)|(?=\\*))");
        int one = 0;
        int two = 0;

        String currWord = words[1];
        if (Character.isLetter(currWord.charAt(0))) {
            int col = currWord.charAt(0) - 'A';
            int row = Integer.parseInt(currWord.substring(1)) - 1;

            one = spreadsheet[col][row];
        }
        else {
            one = Integer.parseInt(currWord);
        }

        currWord = words[3];
        if (Character.isLetter(currWord.charAt(0))) {
            int col = currWord.charAt(0) - 'A';
            int row = Integer.parseInt(currWord.substring(1)) - 1;

            two = spreadsheet[col][row];
        }
        else {
            two = Integer.parseInt(currWord);
        }

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
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */