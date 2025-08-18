class Solution {
    private boolean backtracking(ArrayList<Double> cards) {
        if (cards.size() == 1) {
            return Math.abs(cards.get(0) - 24.0) < 1e-6;
        }

        int size = cards.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j){
                    continue;
                }

                ArrayList<Double> newArrayList = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    if (k != i && k != j) {
                        newArrayList.add(cards.get(k));
                    }
                }

                ArrayList<Double> results = new ArrayList<>();
                double a = cards.get(i);
                double b = cards.get(j);

                results.add(a + b);
                results.add(a - b);
                results.add(b - a);
                results.add(a * b);
                if (a != 0) {
                    results.add(a / b);
                }
                if (a != 0) {
                    results.add(b / a);
                }

                for (int k = 0; k < results.size(); k++){
                    newArrayList.add(results.get(k));
                    if (backtracking(newArrayList)) {
                        return true;
                    }
                    newArrayList.remove(newArrayList.size()-1);
                }
                

            }
        }

        return false;
    }

    public boolean judgePoint24(int[] cards) {
        ArrayList<Double> cardsDouble = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            cardsDouble.add((double)cards[i]);
        }

        return backtracking(cardsDouble);
    }
}