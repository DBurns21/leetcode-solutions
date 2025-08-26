class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int largest = 0;
        int area = 0;

        for (int i = 0; i < dimensions.length; ++i) {
            //changed code a little bit for better readability
            //now instead of dimensions[i][0 or 1] I have it set to a or b 
            int a = dimensions[i][0];
            int b = dimensions[i][1];
            //we also don't need to find the square root so we just skip that part 
            int check = a * a + b * b;

            if (check > largest) {
                largest = check;
                area = a * b;
            }
            //in the case that more than one have the same size we then want to see which has the larger area which is what made me fail a few test orignally
            else if (check == largest) {
                int tempArea = a * b;
                if (tempArea > area) {
                    area = tempArea;
                }
            }
        }
        return area;
    }
}