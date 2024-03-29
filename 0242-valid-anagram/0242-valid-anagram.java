class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length() || s == null || t == null) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) -1);
        }
        // for(char c : t.toCharArray()){
        //     map.put(c, map.getOrDefault(c,0) -1);
        // }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > 0){
                return false;
            }
        }
        return true;
    }
}