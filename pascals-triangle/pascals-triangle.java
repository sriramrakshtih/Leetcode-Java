class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(1);
        
        for(int i = 1; i < numRows; i++){
            List<Integer> li = new ArrayList<>();
            List<Integer> prevRow = res.get(i-1);
            li.add(1);
            for(int j = 1; j < i; j++){
                li.add(prevRow.get(j-1) + prevRow.get(j));   
            }
            li.add(1);
            res.add(li);
        }
        return res;
    }
}