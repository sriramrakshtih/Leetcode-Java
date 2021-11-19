class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int begin = 0; int end = 0;
        int len = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int counter = map.size();
        
        while(end < s.length()) {
            char endC = s.charAt(end);
            if(map.containsKey(endC)){
                map.put(endC, map.get(endC) - 1);
                if(map.get(endC) == 0) counter--;
            }
            end++;
            
            while(counter == 0) {
                char beginC = s.charAt(begin);
                if(map.containsKey(beginC)) {
                    map.put(beginC, map.get(beginC) + 1);
                    if(map.get(beginC) > 0) counter++;
                }
                
                if(end - begin == p.length()){
                    res.add(begin);
                }
                
                begin++;
            }
        }
        
        return res;
    }
}