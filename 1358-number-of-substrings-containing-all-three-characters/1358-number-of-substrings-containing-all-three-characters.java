class Solution {
    public int numberOfSubstrings(String s) {
        int lastSeen[] = new int[3];
        Arrays.fill(lastSeen,-1);
        int count = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            lastSeen[ch-'a'] = i;

            if(lastSeen[0]!=-1 && lastSeen[1] !=-1 && lastSeen[2] !=-1){
                count = count + (1+Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2])));
            }
        }
        return count;
    }
}