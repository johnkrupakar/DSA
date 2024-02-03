class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //without using extra space
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        //total size
        int n = n1 + n2;
        
        //required indices
        int ind2 = n/2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1element = -1;
        int ind2element = -1;
        
        //apply merge sort
        int i=0;
        int j=0;
        while(i< n1 && j < n2){
            if(nums1[i] < nums2[j]){
                if(cnt == ind1) ind1element = nums1[i];
                if(cnt == ind2) ind2element = nums1[i];
                cnt++;
                i++;
            }
            else{
                if(cnt == ind1) ind1element = nums2[j];
                if(cnt == ind2) ind2element = nums2[j];
                cnt++;
                j++;
            }
        }
        
        while(i<n1){
            if(cnt == ind1) ind1element = nums1[i];
            if(cnt == ind2) ind2element = nums1[i];
            cnt++;
            i++;
        }
        
        while(j<n2){
            if(cnt == ind1) ind1element = nums2[j];
            if(cnt == ind2) ind2element = nums2[j];
            cnt++;
            j++;
        }
        
        //Find the median:
        if(n%2 == 1){
            return (double)ind2element;
        }
        return (double)((double)(ind1element + ind2element)) / 2.0;
    }
}