class Solution {
    String str = "aeiou";
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int res = 0;
        for(int i=0;i<n;i++){
            int consonants = 0;
            Set<Character> st = new HashSet<>();
            for(int j=i;j<n;j++){
                char ch = word.charAt(j);
                if(str.indexOf(ch) != -1){
                    st.add(ch);
                }
                else{
                    consonants++;
                }

                if(consonants > k){
                    break;
                }
                if(st.size() == 5 && consonants == k){
                    res++;
                }
            }
        }
        return res;
    }
}