class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Edge Cases
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If nums[mid] is the peak:
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Left half of the peak element is sorted in ascending order
            // Right half of the peak element is sorted in descending order
            // If we are in the left:
            if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            }
            // If we are in the right:
            // Or, nums[mid] is a common point:
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}