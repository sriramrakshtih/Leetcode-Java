class Solution {
    
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict){
        map.clear();
        return wordBreak1(s, wordDict);
    }
    
    public boolean wordBreak1(String s, List<String> wordDict) {
        if(map.containsKey(s)){
            return map.get(s);
        }
        for(int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i+1);
            if(sub.equals(s)){
                map.put(sub, wordDict.contains(sub));
                return wordDict.contains(sub);
            }
            if(wordDict.contains(sub)){
                boolean x = wordBreak1(s.substring(i+1), wordDict);
                if(x == true){
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}