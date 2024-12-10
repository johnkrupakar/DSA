class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int maxind = 0;
        int hash[] = new int[26];
        while(r < s.length()){
            char ch = s.charAt(r);
            hash[ch-'A']++;

            //maximum frequency of char in that string
            maxind = Math.max(maxind,hash[ch-'A']);
            if(((r-l+1)-maxind) > k){
                //then move the l and remove the freq of that char in hash
                char lch = s.charAt(l);
                hash[lch-'A']--;
                l++;
            }
            if(((r-l+1) - maxind) <= k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}