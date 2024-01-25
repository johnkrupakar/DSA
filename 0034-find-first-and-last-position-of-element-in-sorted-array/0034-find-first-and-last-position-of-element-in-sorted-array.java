class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, n, target);
        if (lb == n || nums[lb] != target) {
            return new int[]{-1, -1};
        }
        int ub = upperBound(nums, n, target);
        return new int[]{lb, ub - 1};
    }
    
public static int lowerBound(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static int upperBound(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}