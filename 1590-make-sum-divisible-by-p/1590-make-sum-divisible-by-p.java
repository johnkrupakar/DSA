class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;

        for(int num:nums){
            totalSum = (totalSum + num) % p;
        }

        int target = totalSum % p;
        if(target == 0){
            return 0;
        }

        HashMap<Integer,Integer> modMap = new HashMap<>();
        modMap.put(0, -1); //to hadle the case where whole prefix is the ans
        int currSum = 0;
        int minLen = n;

        for(int i=0;i<n;i++){
            currSum = (currSum + nums[i]) % p;
            int needed = (currSum - target + p) % p;

            if(modMap.containsKey(needed)){
                minLen = Math.min(minLen,i - modMap.get(needed));
            }
            //store the current remainder and index
            modMap.put(currSum,i);
        }
        return minLen == n ? -1:minLen;
    }
}