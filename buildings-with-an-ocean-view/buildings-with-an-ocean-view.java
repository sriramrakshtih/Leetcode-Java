class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list  = new ArrayList<>();
        
        for(int i = 0; i < heights.length; i++) {
            while(!list.isEmpty() && heights[list.get(list.size()-1)] <= heights[i]){
                list.remove(list.size()-1);
            }
            list.add(i);
        }
        
        int [] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}