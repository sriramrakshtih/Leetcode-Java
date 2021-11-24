class Solution {
    public int countBinarySubstrings(String s) {
        int [] group = new int [s.length()];
        int t = 0;
        group[0] = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1) != s.charAt(i)){
                group[++t] = 1;
            } else {
                group[t]++;
            }
        }
        int res = 0;
        for(int i = 1; i <= t; i++) {
            res += Math.min(group[i-1], group[i]);
        }
        return res;
    }
}