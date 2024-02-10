class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++){
            boolean flag = binarySearch(matrix[i],target);
            if(flag == true){
                return true;
            }
        }  
        return false;
    }
    
    public static boolean binarySearch(int []arr,int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return false;
    }
}