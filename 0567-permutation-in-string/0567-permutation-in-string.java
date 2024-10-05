class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        if(n1 > n2){
            return false;
        }
        
        //create 2 arrays of size 26 because total alphabets = 26 to store 
        //frequency
        
        int s1map[] = new int[26];
        int s2map[] = new int[26];
        
        // we find the frequencies of first window of size n1
        
        for(int i=0;i<n1;i++){
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        
        //then we will iterate over other window till both windows becomes equal
        
        //start the loop from n1 because n1-1 has the last window
        for(int i=n1;i<n2;i++){
            // before going to the next window first check the current window 
            // if the frequencies are same then return true;
            if(bothAreEqual(s1map,s2map)){
                return true;
            }
            //add the current element frequency 
            s2map[s2.charAt(i) - 'a']++;
            //reduce the i-window size frequency as it is not a part of the current 
            // window
            s2map[s2.charAt(i-n1) - 'a']--;
        }
        //after every window check if both window are equal or not
        return bothAreEqual(s1map,s2map);
    }
    
    //here this function will check if the every element s1map and s2map 
    //if the frequencies of current window in both the map then it will return true
    public static boolean bothAreEqual(int s1map[],int s2map[]){
        for(int i=0;i<26;i++){
            if(s1map[i] != s2map[i]){
                return false;
            }
        }
        return true;
    }
}