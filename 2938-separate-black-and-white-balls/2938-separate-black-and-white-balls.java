class Solution {
    public long minimumSteps(String s) {
        int whites = 0;
        long totalSwaps = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                totalSwaps += i - whites;
                whites++;
            }
        }
        return totalSwaps;
    }
}