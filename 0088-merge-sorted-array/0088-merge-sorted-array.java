class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //As question stated the two arrays are sorted
        //1st array is already sorted we need to fill the 0's by comparing and traversing the 
        //2nd array from the back
        int p1 = m-1;
        int p2 = n-1;
        int i = m+n-1;
        
        while(p2 >= 0){
            //check the last element of the 1st array with the pointer2 element in 2nd array
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[i--] = nums1[p1--];   
            }
            else{
                nums1[i--] = nums2[p2--];
            }
        }
    }
}