class Solution {
    public boolean validPalindrome(String s) {
        int l = -1; int h = s.length();
        while(++l < --h) {
            if(s.charAt(l) != s.charAt(h)){
                return isPalindrome(s, l-1, h) || isPalindrome(s, l, h+1);
            }
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        
        while(++i < --j){
            if(s.charAt(i) != s.charAt(j)){    
                return false;
            }
        }
        return true;
    }
}