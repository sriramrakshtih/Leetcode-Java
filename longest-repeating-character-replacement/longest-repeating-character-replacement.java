class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; int maxLen = Integer.MIN_VALUE;
        int charCount = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char charR = s.charAt(i);
            
            map.put(charR, map.getOrDefault(charR, 0) + 1);
            charCount = Math.max(charCount, map.get(charR));
            
            if(i - left + 1 - charCount > k) {
                char charL = s.charAt(left);
                map.put(charL, map.get(charL) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        } 
        return maxLen;
    }
}