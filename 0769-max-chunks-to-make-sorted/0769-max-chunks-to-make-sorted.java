class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int count = 0;
        
        int lmax[] = new int[n];
        lmax[0] = arr[0];
        for(int i=1;i<n;i++){
            lmax[i] = Math.max(arr[i],lmax[i-1]);
        }
        for(int i=0;i<n;i++){
            if(lmax[i] == i){
                count++;
            }
        }
        return count;
    }
}