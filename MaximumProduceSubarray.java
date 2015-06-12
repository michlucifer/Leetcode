public class Solution {
    public int maxProduct(int[] A) {
        if(A == null || A.length == 0)
        {
            return 0;
        }
        if(A.length == 1)
        {
            return A[0];
        }
        
        int local_max = A[0];
        int local_min = A[0];
        int global = A[0];
        
        for(int i = 1; i < A.length; i ++)
        {
            int copy_max = local_max;
            local_max = Math.max(Math.max(A[i],A[i]*local_max),A[i]*local_min);
            local_min = Math.min(Math.min(A[i],A[i]*copy_max),A[i]*local_min);
            global = Math.max(global,local_max);
            // int max_copy = max_local;  
            // max_local = Math.max(Math.max(A[i]*max_local, A[i]), A[i]*min_local);  
            // min_local = Math.min(Math.min(A[i]*max_copy, A[i]), A[i]*min_local);  
            // global = Math.max(global, max_local); 
        }
        return global;
    }
}
