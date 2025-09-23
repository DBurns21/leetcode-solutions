class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int longest = 0;
        if (v1.length > v2.length) {
            longest = v1.length;
        }
        else {
            longest = v2.length;
        }

        int curr1 = 0;
        int curr2 = 0;

        for (int i = 0; i < longest; ++i) {
            if (i >= v1.length) {
                curr1 = 0;
            }
            else {
                curr1 = Integer.parseInt(v1[i]);
            }

            if (i >= v2.length) {
                curr2 = 0;
            }
            else {
                curr2 = Integer.parseInt(v2[i]);
            }

            if (curr1 > curr2) {
                return 1;
            }
            if (curr2 > curr1) {
                return -1;
            }
        }

        return 0;
    }
}