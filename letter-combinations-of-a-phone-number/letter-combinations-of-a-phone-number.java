class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        
        HashMap<Character, String> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        dfs(0, digits, new StringBuilder(), res, map);
        //System.out.print(map);
        
        return res;
    }
    
    private void dfs(int index, String digits, StringBuilder sb, List<String> res, HashMap<Character, String> map) {
        //base case
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }
        
        
        //logic
        String str = map.get(digits.charAt(index));
        for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));
            dfs(index + 1, digits, sb, res, map);
            sb.setLength(sb.length() - 1);
        }
            
    }
}
