class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = 0;
        
        for(int i=0;i<n;i++){
            if(count == 0){
                count = 1;
                element = nums[i];
            }
            else if(element == nums[i]) count++;
            else count--;
        }
        
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(element == nums[i]){
                cnt++;
            }
        }
        
        if(cnt <= n/2){
            return -1;
        }
        return element;
    }
}