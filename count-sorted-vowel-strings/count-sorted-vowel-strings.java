class Solution {
    public int countVowelStrings(int n) {
        return backtrack(n, 1);
    }
    
    private int backtrack(int n, int vowels) {
        if(n == 0){
            return 1;
        }
        
        int res = 0;
        for(int i = vowels; i <= 5; i++) {
            res += backtrack(n-1, i);
        }
        return res;
    }
}