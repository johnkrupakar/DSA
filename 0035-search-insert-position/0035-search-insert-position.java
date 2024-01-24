class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length;

        while(low <= high){
            int mid = (low + high) /2;
            if(nums[mid] >= target){
                ans = mid;
                 //look for smaller index on the left
                high = mid-1;
            }
            else{
                low = mid+1; // look on the right
            }
        }
        return ans;
    }
}