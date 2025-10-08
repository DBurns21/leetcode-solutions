class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int numOfSpells = spells.length;
        int numOfPotions = potions.length;
        Arrays.sort(potions);

        int[] ans = new int[numOfSpells];

        for (int i = 0; i < numOfSpells; ++i) {
            int curr = bfs((int)Math.ceil((double)success/spells[i]), potions);
            
            ans[i] = numOfPotions - curr;
            
            /*
            for (int j = 0; j < numOfPotions; ++j) {
                if ((long)spells[i] * potions[j] >= success) {
                    ans[i] = numOfPotions - j;
                    break;
                }
            }
            */
        }

        return ans;
    }

    private int bfs(int t, int[] arr) {
        int low = 0;
        int high = arr.length-1;
        int result = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= t) {
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }
}