class CustomStack {

    private int[] st;
    private int top;

    public CustomStack(int maxSize) {
        st = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(top < st.length-1){
            st[++top] = x;
        }
    }
    
    public int pop() {
        if(top >= 0){
            return st[top--];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k, top+1);
        for(int i=0;i<limit;i++){
            st[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */