class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums,goal) - func(nums,goal-1);
    }
    public int func(int[] nums, int goal){
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        if(goal < 0){
            return 0;
        }
        while(r < nums.length){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
}