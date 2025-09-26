class Solution {
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j <= high - 1; ++j) {
            if (arr[j] < pivot) {
                ++i;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;
        return i + 1;
    }

    static void qs(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            qs(arr, low, pi-1);
            qs(arr, pi+1, high);
        }
        
    }

    static int bs(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        //System.out.println("Searching for " + x);
        for (int num : arr){
            //System.out.print(num + ", ");
        }
        //System.out.println();
        /*
        if (high == 0) {
            return 0;
        }
        */
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < x) {
                if (mid == arr.length-1 || (mid < arr.length-1 && arr[mid+1] >= x)) {
                    return mid;
                }

                low = mid+1;
            }
            else{ 
                high = mid-1;
            }
        }

        return -1;
    }

    public int triangleNumber(int[] nums) {
        int size = nums.length;
        if (size < 3) {
            return 0;
        }

        qs(nums, 0, size-1);

        /*
        Greedy approach alone will not work
        int ans = 0;
        for (int i = 0; i < size-2; ++i) {
            int a = nums[i];
            for (int j = i+1; j < size-1; ++j) {
                int b = nums[j];
                for (int k = j+1; k < size; ++k) {
                    int c = nums[k];
                    if (a+b > c && a+c > b && b+c > a) {
                        ans++;
                    }
                }
            }
        }
        




        int ans = 0;
        for (int i = 0; i < size-2; ++i) {
            int a = nums[i];
            for (int j = i+1; j < size-1; ++j) {
                int b = nums[j];

                int start = bs(Arrays.copyOfRange(nums, j+1, size), a+b+1);
                if (start == -1) {
                    //System.out.println("start is -1 a: " + a +" b: " + b);
                    break;
                }
                start += j+1;
                //System.out.println("statr now is " + start);
                for (int k = start; k > j; --k) {
                    int c = nums[k];
                    if (a+b > c && a+c > b && b+c > a) {
                        ans++;
                    }
                }
            }
        }
        */


        int ans = 0;
        for (int i = nums.length - 1; i > 1; --i) {
            int left = 0;
            int right = i-1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ans += right - left;
                    right--;
                }
                else {
                    left++;
                }
            }
        }

        return ans;
    }
}