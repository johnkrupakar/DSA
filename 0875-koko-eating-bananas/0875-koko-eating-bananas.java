class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while(low <= high){
            int mid = (low + high)/2;
            int totalH = calculateTotalHours(piles,mid);
            if(totalH <= h){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    
    //calculate the max in the array as the binary serach rum from 1 to max of array
    public static int findMax(int[] piles){
        int n = piles.length;
        int maxi = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            maxi = Math.max(maxi,piles[i]);
        }
        return maxi;
    }
    public static int calculateTotalHours(int[] piles,int hourly){
        int totalH = 0;
        int n = piles.length;
        
        //divide the each element with mid
        for(int i=0;i<n;i++){
            totalH += Math.ceil((double)piles[i]/(double)hourly);
        }
        return totalH;
    }
}