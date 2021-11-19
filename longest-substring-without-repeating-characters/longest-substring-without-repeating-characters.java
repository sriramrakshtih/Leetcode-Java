class Solution {
    public int lengthOfLongestSubstring(String s) {
        int begin = 0; int end = 0;
        int len = 0, counter = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        while(end < s.length()){
            char endC = s.charAt(end);
            map.put(endC, map.getOrDefault(endC, 0) + 1);
            if(map.get(endC) > 1){
                counter++;
            }
            end++;
            
            while(counter > 0) {
                char beginC = s.charAt(begin);
                if(map.get(beginC) > 1) counter--;
                map.put(beginC, map.get(beginC) - 1);
                begin++;
            }
            
            if(end - begin > len) {
                len = end - begin;
            }
        }
        
        return len;
    }
}