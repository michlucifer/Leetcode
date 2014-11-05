public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        if(len == 0 || dict.size() == 0) {
            return false;
        }
        boolean[] arrays = new boolean[len+1];
        arrays[0] = true;
        for (int i=1; i<=len; i++) {
            for (int j=0; j<i; j++) {
                if(arrays[j] && dict.contains(s.substring(j,i))) {
                    arrays[i] = true;
                }
            }
        }
        return arrays[len];
    }
}

/* dict.size VS s.length() */
