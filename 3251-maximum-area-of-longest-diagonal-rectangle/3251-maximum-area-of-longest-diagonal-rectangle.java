class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int largest = dimensions[0][0] * dimensions[0][0] + dimensions[0][1] * dimensions[0][1];
        int area = dimensions[0][0] * dimensions[0][1];
        System.out.println( Math.sqrt(dimensions[0][0] * dimensions[0][0] + dimensions[0][1] * dimensions[0][1]));

        for (int i = 1; i < dimensions.length; ++i) {
            int check = dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1];
            System.out.println(check);

            if (check > largest) {
                largest = check;
                area = dimensions[i][0] * dimensions[i][1];
            }
            else if (check == largest) {
                int tempArea = dimensions[i][0] * dimensions[i][1];
                if (tempArea > area) {
                    area = tempArea;
                }
            }
        }
        return area;
    }
}