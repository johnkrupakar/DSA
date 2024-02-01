class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = nums[0];
        int high = 0;

        //find maximum and summation:
        for(int i=0;i<n;i++){
            low = Math.max(low,nums[i]);
            high += nums[i];
        }

        //Apply binary search:
        while(low <= high){
            int mid = (low + high)/2;
            
            int partitions = countPartitions(nums,mid);
            if(partitions > k){
                //insert element to current subarray
                low = mid + 1;
            }
            //insert element to next subarray
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static int countPartitions(int[] a,int maxSum){
        int n = a.length;
        int partitions = 1;
        int subarraySum = 0;
        
        for(int i=0;i<n;i++){
            if(subarraySum + a[i] <= maxSum){
                subarraySum += a[i];
            }
            else{
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }
}