class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long)m * k;
        int n = bloomDay.length;
        if(val > n) return -1; // Impossible case.

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        // Find maximum and minimum:
        for(int i=0;i<n;i++){
            mini = Math.min(mini,bloomDay[i]);
            maxi = Math.max(maxi,bloomDay[i]);
        }

        // Apply binary search:
        int low = mini;
        int high = maxi;
        while(low <= high){
            int mid = (low + high)/2;
            
            if(possible(bloomDay,mid,k,m)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static boolean possible(int[] arr,int day, int k,int m){
        int n = arr.length;
        int cnt = 0;
        int noOfB = 0;

        // Count the number of bouquets:
        for(int i=0;i<n;i++){
            if(arr[i] <= day){
                cnt++;
            }
            else{
                noOfB += (cnt/k);
                cnt = 0;
            }
        }
        noOfB += (cnt/k);
        return noOfB >= m;
    }
}