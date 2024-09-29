class Solution {
    String str = "aeiou";
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int res = 0;
        for(int i=0;i<n;i++){
            Set<Character> st = new HashSet<>();
            for(int j=i;j<n;j++){
                char ch = word.charAt(j);
                if(str.indexOf(ch) != -1){
                    st.add(ch);

                    if(st.size() == 5){
                        res++;
                    }
                }
                else{
                    break;
                }
            }
        }
        return res;
    }
}