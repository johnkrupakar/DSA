class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        int temp = 0;

        while(mid <= high){
            switch(nums[mid]){
                // If arr[mid] == 0, we will swap arr[low] and arr[mid] and will
                // increment both low and mid. Now the subarray from index 0 t
                // (low-1) only contains 0.
                case 0:
                swap(nums,low,mid);
                mid++;
                low++;
                break;

                // If arr[mid] == 1, we will just increment the mid pointer and 
                // then the index (mid-1) will point to 1 as it should according 
                // to the rules.
                case 1:
                mid++;
                break;

                // If arr[mid] == 2, we will swap arr[mid] and arr[high] and will
                // decrement high. Now the subarray from index high+1 to (n-1) only
                // contains 2.
                case 2:
                swap(nums,mid,high);
                high--;
                break;
            }
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}