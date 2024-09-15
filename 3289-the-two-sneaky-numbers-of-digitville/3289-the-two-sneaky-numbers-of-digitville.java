class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int res[] = new int[2];
        int freq[] = new int[n];
        
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        
        int pt=0;
        for(int i=0;i<n;i++){
            if(freq[i] == 2){
                res[pt++] = i;
            }
        }
        return res;
    }
}