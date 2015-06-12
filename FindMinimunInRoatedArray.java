public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length == 0)
            return 0;
        int l = 0;
        int r = num.length-1;
        int m;
        int min = num[0];
        while(l<r-1) {
            m = (l+r)/2;
            if(num[l] < num[m]) {
                min = Math.min(num[l],min);
                l = m+1;
            }
            else if(num[l] > num[m]) {
                min = Math.min(num[m],min);
                r = m-1;
            }
            else {
                l++;
            }
        }
        min = Math.min(num[l],min);
        min = Math.min(num[r],min);
        return min;
        
    }
}
