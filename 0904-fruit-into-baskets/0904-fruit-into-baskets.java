class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int n=fruits.length;
        int ans=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int r=0;r<n;r++){
            int val=fruits[r];
            hm.put(val,hm.getOrDefault(val,0)+1);

            while(hm.size()>2){
                int leftValue=fruits[l];
                
                hm.put(leftValue,hm.get(leftValue)-1);
                if(hm.get(leftValue)==0){
                    hm.remove(leftValue);
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}