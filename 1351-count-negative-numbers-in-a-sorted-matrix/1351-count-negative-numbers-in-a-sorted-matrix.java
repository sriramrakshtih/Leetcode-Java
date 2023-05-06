class Solution {
    public int countNegatives(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int n = grid[0].length; 
        int currRowNeIdx = n-1;
        int count = 0;
        
        for(int [] row : grid) {
            while(currRowNeIdx >= 0 && row[currRowNeIdx] < 0){
                currRowNeIdx--;
            }
            count += (n - (currRowNeIdx + 1));
        }
        return count;
    }
}