class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        HashMap<Integer, Integer> lakeToDay = new HashMap();

        int dryDays = 0;

        for (int i = 0; i < rains.length; ++i) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays++;
            }
            else {
                ans[i] = -1;
                if (lakeToDay.containsKey(lake)) {
                    int lastRain = lakeToDay.get(lake);
                    lakeToDay.remove(lake);
                    if (dryDays == 0) {
                        return new int[0];
                    }

                    boolean foundDay = false;
                    for (int j = lastRain; j < i; ++j) {
                        if (ans[j] == 0) {
                            ans[j] = lake;
                            foundDay = true;
                            break;
                        }
                    }
                    if(!foundDay) {
                        return new int[0];
                    }
                    dryDays--;
                }
                
                lakeToDay.put(lake, i);
            }
        }

        for (int i = 0; i < ans.length; ++i) {
            if (ans[i] == 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }
}