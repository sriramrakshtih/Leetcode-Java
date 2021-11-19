class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int begin = 0; int end = 0; int head = 0;
        int len = Integer.MAX_VALUE;
        String res = ""; 
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int counter = map.size();
        while(end < s.length()) {
            char endC = s.charAt(end);
            
            if(map.containsKey(endC)){
                map.put(endC, map.get(endC) - 1);
                if(map.get(endC) == 0) counter--;
            }
            end++;
            //System.out.println("Begin " + begin + " end " + end);
            
            while(counter == 0) {
                
                char beginC = s.charAt(begin);
                if(map.containsKey(beginC)){
                    map.put(beginC, map.get(beginC) + 1);
                    if(map.get(beginC) > 0) counter++;
                }
                
                if(end - begin < len){
                    len = end - begin;
                    head = begin;
                    
                }
                begin++;
            }
        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head + len);
    }
}