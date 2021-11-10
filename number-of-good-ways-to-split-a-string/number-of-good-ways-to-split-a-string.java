class Solution {
    public int numSplits(String s) {
        int goodSplits = 0;
        int [] left = new int [26];
        int [] right = new int [26];
        
        for(int i = 0 ;i < s.length(); i++) {
            char c = s.charAt(i);
            right[c - 'a']++;
        }
        
        for(int i = 0 ;i < s.length(); i++) {
            char c = s.charAt(i);
            left[c - 'a']++;
            right[c - 'a']--;
            
            int leftSp = good(left);
            int rightSp = good(right);
            
            if(leftSp == rightSp) goodSplits++;
        }
        
        return goodSplits;
    }
    
    private int good(int [] count) {
        int c = 0;
        for(int i : count) {
            if(i != 0)
                c++;
        }
        return c;
    }
}