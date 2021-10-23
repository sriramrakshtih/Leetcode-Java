class Solution {
    public int numSplits(String s) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        map1.put(s.charAt(0), 1);
        for(int i = 1; i < s.length(); i++) {
            if(!map2.containsKey(s.charAt(i))){
                map2.put(s.charAt(i), 0);
            }
            map2.put(s.charAt(i), map2.get(s.charAt(i)) + 1);
        }
        
        System.out.print(map1);
        System.out.print(map2);
        
        
        int count = 0;
        for(int i = 1; i < s.length(); i++) {
            if(map1.size() == map2.size()){
                count++;
            }
            
            
            if(map1.containsKey(s.charAt(i))){
                map2.put(s.charAt(i), map2.get(s.charAt(i)) - 1);
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            } else {
                map1.put(s.charAt(i), 0);
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
                map2.put(s.charAt(i), map2.get(s.charAt(i)) - 1);
                
            }
            
            if(map2.get(s.charAt(i)) == 0){
                map2.remove(s.charAt(i));
            }
        }
        
        return count;
    }
}