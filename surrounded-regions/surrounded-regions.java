class Solution {
    class Pair<U,V>{
        public U first;
        public V second;
        
        public Pair(U first, V second){
            this.first = first;
            this.second = second;
        }  
    }
    
    int m; int n;
    
    public void solve(char[][] board) {
        m = board.length; n = board[0].length;
        if(m == 0 || n == 0) return;
        List<Pair<Integer, Integer>> q = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O'){
                //board[i][0] = 'R';
                q.add(new Pair(i, 0));    
            }
            if(board[i][n-1] == 'O'){
                //board[i][n-1] = 'R';
                q.add(new Pair(i, n-1));
            }
        }
        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O'){
                //board[0][i] = 'R';
                q.add(new Pair(0, i));
            }
            
            if(board[m-1][i] == 'O'){
                //board[m-1][i] = 'R';
                q.add(new Pair(m-1, i));
            }
            
        }
        
        for(Pair<Integer, Integer> pa : q){
            dfs(board, pa.first, pa.second);
        }
        
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'R'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j){
        
        int [][] dirs = {{0,1},{1,0}, {0,-1}, {-1,0}};
        
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;
        
        board[i][j] = 'R';
        for(int [] dir : dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            
            dfs(board, row, col);
            
        }
    }
}