class Solution {
    public boolean canSortArray(int[] nums) {
        int arr[] = new int[101];
        for(int i=0;i<nums.length;i++){
            arr[i] = noOfBits(nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            if(isSorted(nums)){
                return true;
            }

            for(int j=1;j<nums.length;j++){
                //check if bits are equal for consecutive indexies 
                //if equal move the bit to it correct position
                if(arr[j] == arr[j-1] && nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        return false;
    }
    public int noOfBits(int n){
        int count = 0;
        while(n > 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public boolean isSorted(int arr[]){
        for(int i=0;i<arr.length - 1;i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
}