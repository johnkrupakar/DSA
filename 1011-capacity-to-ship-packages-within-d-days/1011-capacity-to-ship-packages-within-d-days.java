class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0;i<weights.length;i++){
            high += weights[i];
            low = Math.max(low,weights[i]);
        }

        while(low <= high){
            int mid = (low + high)/2;
            int numberOfDays = findDays(weights,mid);

            if(numberOfDays <= days){
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    
    public static int findDays(int[] weights, int cap){
        int days = 1; //first day
        int load = 0;
        int n = weights.length;

        for(int i=0;i<n;i++){
            if(load + weights[i] > cap){
                days += 1; //move to next day
                load = weights[i]; //resetting the load if it exceeds from 0 to current load
            }
            else{
                //load the weight on the same day.
                load += weights[i];
            }
        }
        return days;
    }
}