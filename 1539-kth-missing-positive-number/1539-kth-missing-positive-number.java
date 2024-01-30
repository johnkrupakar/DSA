class Solution {
    public int findKthPositive(int[] arr, int k) {
        //brute force
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }
}