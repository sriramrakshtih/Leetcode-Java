class Solution {
    public int lengthOfLongestSubstring(String s) {
//         int max = 0;
//         int slow = 0;
//         HashMap<Character, Integer> map = new HashMap<>();
//         for(int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if(map.containsKey(c)){
//                 slow = Math.max(slow, map.get(c));
//             } 
//             map.put(c, i+1);
//             max = Math.max(max, i - slow + 1);
//         }
        
//         return max;
//     }
    
        int maxx = 0;
        int slow = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, i+1);
            maxx = Math.max(maxx, i - slow + 1);
        }
            return maxx;
    }
    
}