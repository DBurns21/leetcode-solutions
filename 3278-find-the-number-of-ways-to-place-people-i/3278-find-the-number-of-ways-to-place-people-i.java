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

        for (int i = 0; i < sorted.size(); ++i) {
            //System.out.println(sorted.get(i)[0] + ", " + sorted.get(i)[1]);
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
                    
                    for (int k = i+1; k < j; ++k) {
                        if (k == i || k == j) {
                            continue;
                        }

                        int x = sorted.get(k)[0];
                        int y = sorted.get(k)[1];

                        //System.out.println("k != i or j");
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