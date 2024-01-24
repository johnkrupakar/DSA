class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n-1);
    }
    
    public static int mergeSort(int[] arr, int low, int high){
        int cnt = 0;
        //base case for recursion to end
        if(low >= high) return cnt;
        int mid = (low + high)/2;
        cnt += mergeSort(arr,low,mid); //recursive call for left half
        cnt += mergeSort(arr,mid+1,high); //recursive call for right half
        cnt += countPairs(arr,low,mid,high);
        merge(arr,low,mid,high); //merging sorted half
        return cnt;
    }

    public static int countPairs(int[] arr, int low, int mid, int high){
        int right = mid+1;
        int cnt = 0;
        for(int i=low;i<=mid;i++){
            //check the right half util we get pair
            while(right <= high && arr[i] > (2 * (long)arr[right])){
                right++;
            }
            //calculate the count till that found pair
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static void merge(int[] arr,int low,int mid,int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low; // starting index of left half of arr
        int right = mid +1; // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr 
        for(int i=low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }
    }
}