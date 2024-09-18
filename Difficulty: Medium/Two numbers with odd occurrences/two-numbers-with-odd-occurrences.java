//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
        int[] res = new int[2];
        long xor = 0;
        for(int i=0;i<N;i++){
            xor = xor ^ Arr[i];
        }
        
        long rightMostBit = (xor & xor-1) ^ xor;
        
        int bucket1 = 0;
        int bucket2 = 0;
        
        for(int i=0;i<N;i++){
            if((Arr[i] & rightMostBit) != 0){
                bucket1 = bucket1 ^ Arr[i];
            }
            else{
                bucket2 = bucket2 ^ Arr[i];
            }
        }
        res[0] = Math.max(bucket1,bucket2);
        res[1] = Math.min(bucket1,bucket2);
        return res;
    }
}