class Solution {
    public boolean rotateString(String s, String goal) {
        //check the lengths
        if(s.length() != goal.length()){
            return false;
        }

        //Create a string by concatenation s with itself
        String doubledString = s+s;

        // Use contains to search for 'goal' in 'doubledString'
        // If contains return true, 'goal' is a substring
        return doubledString.contains(goal);
    }
}