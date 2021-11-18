class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(!visited.contains(i)){
                count++;
                dfs(isConnected, i, visited);
            }            
        }
        return count;
    }
    
    private void dfs(int [][] matrix, int index, HashSet<Integer> visited) {
        for(int i = 0; i < matrix.length;i++)  {
            if(!visited.contains(i) && matrix[index][i] == 1){
                visited.add(i);
                dfs(matrix, i, visited);
            }
        }
    }
}