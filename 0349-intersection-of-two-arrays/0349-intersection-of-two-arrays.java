class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int n = nums1.length;
        int m = nums2.length;
        
        Set<Integer> s = new HashSet<>();
        int p1 = 0;
        int p2 = 0;
        
        while(p1<n && p2<m){
            if(nums1[p1] == nums2[p2]){
                s.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else{
                p2++;
            }
        }
        int size = s.size();
        int res[] = new int[size];
        int curr = 0;
        for(int x : s){
            res[curr++] = x;
        }
        
        return res;
    }
}