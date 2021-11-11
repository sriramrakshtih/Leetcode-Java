class Solution {
    HashMap<String, Integer> map;
    HashSet<String> set;
    public int longestStrChain(String[] words) {
        set = new HashSet<>();
        map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        int res = 0;
        for(String str : words) {
            res = Math.max(res, dfs(str));
        }
        
        return res;
    }
    
    private int dfs(String str) {
        if(map.containsKey(str)) {
            return map.get(str);
        }
        
        int maxLen = 1;
        StringBuilder sb = new StringBuilder(str);
        
        for(int i = 0; i < str.length(); i++) {
            sb.deleteCharAt(i);
            String sbStr = sb.toString();
            
            if(set.contains(sbStr)){
                int currLength = 1 + dfs(sbStr);
                maxLen = Math.max(maxLen, currLength);
            }
            
            sb.insert(i, str.charAt(i));
        }
        
        map.put(str, maxLen);
        
        return maxLen;
    }
}