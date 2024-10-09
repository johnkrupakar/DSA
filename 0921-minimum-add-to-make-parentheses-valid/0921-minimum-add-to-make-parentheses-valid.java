class Solution {
    public int minAddToMakeValid(String s) {
        int openBraces = 0;
        int minAddRequired = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                openBraces++;
            }
            else{
                if(openBraces > 0){
                    openBraces--;
                }
                else{
                    minAddRequired++;
                }
            }
        }
        return openBraces + minAddRequired;
    }
}