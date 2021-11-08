class Solution {
    List<String> res;
    public String[] expand(String s) {
        res = new ArrayList<>();
        List<List<Character>> blocks = new ArrayList<>();
        
        int i = 0;
        while(i < s.length()) {
            List<Character> block = new ArrayList<>();
            char c = s.charAt(i);
            if(c == '{') {
                i++;
                while(s.charAt(i) != '}'){
                    if(s.charAt(i) != ','){
                        block.add(s.charAt(i));
                    }
                    i++;
                }
                
            } else {
                block.add(c);
            }
            blocks.add(block);
            i++;
        }
        backtrack(blocks, 0, new StringBuilder());
        String [] arr = new String [res.size()];
        for(int k = 0; k < res.size(); k++){
            arr[k] = res.get(k);
        }
        
        Arrays.sort(arr);
        return arr;
    }
    
    private void backtrack(List<List<Character>> blocks, int index, StringBuilder sb) {
        //base case
        
        if(index == blocks.size()){
            res.add(sb.toString());
            return;
        }
        
        //logic
        List<Character> block = blocks.get(index);
        //action
        for(int i = 0; i < block.size(); i++){
            sb.append(block.get(i));
            //recurse
            backtrack(blocks, index + 1, sb);
            //backtrack
            sb.setLength(sb.length()-1);
        }
        
        
    }
}