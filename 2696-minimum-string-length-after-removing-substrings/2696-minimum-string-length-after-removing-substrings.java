class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);

            if(st.isEmpty()){
                st.push(currentChar);
                continue;
            }
            if(currentChar == 'B' && st.peek() == 'A'){
                st.pop();
            }
            else if(currentChar == 'D' && st.peek() == 'C'){
                st.pop();
            }
            else{
                st.push(currentChar);
            }
        }
        return st.size();
    }
}