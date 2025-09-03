class Solution {
    public int numberOfPairs(int[][] points) {
        int validRect = 0;
        int rows = points.length;
        ArrayList<int[]> sorted = new ArrayList<>();


        sorted.add(points[0]);
        int[] curr = new int[2];
        for (int i = 1; i < rows; ++i) {
            curr = points[i]; 
            for (int j = 0; j < sorted.size(); ++j) {
                if(curr[0] < sorted.get(j)[0]) {
                    sorted.add(j, points[i]);
                    break;
                }
                else if (curr[0] == sorted.get(j)[0] && curr[1] > sorted.get(j)[1]) {
                    sorted.add(j, points[i]);
                    break;
                }
                else if (j == sorted.size() - 1) {
                     sorted.add(points[i]);
                     break;
                }
            }
        }

        int maxX = 0;
        int maxY = 0;
        int minX = 0;
        int minY = 0;

        for (int i = 0; i < sorted.size()-1; ++i) {   
            int[] a = sorted.get(i);
            for (int j = i+1; j < sorted.size(); ++j) {
                boolean notInRect = true;
                int[] b = sorted.get(j);
                if (a[1] >= b[1]) {
                    maxX = Math.max(a[0], b[0]);
                    minX = Math.min(a[0], b[0]);
                    maxY = Math.max(a[1], b[1]);
                    minY = Math.min(a[1], b[1]);
                    
                    //was kinda lazy on this problem since rather than change it as a whole to be more efficient I only change more bits to slightly optimize it.
                    //rather than go from 0 to the length of the array I realized I could end at j since the points are sorted and the next ones will always be outside of the rectangle
                    //I then realized that for the same reason I could start at i + 1 because anything less than it would also always be outside of the rectangle
                    for (int k = i+1; k < j; ++k) {
                        if (k == i || k == j) {
                            continue;
                        }

                        int x = sorted.get(k)[0];
                        int y = sorted.get(k)[1];

                        if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
                            notInRect = false;
                            break;
                        }

                    }
                    if (notInRect) {
                        validRect++;
                    }
                }
    
            }
            
        }
        return validRect;
    }
}