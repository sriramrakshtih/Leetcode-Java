class TicTacToe {
    int [] rows ;
    int [] cols ;
    int diagonal;
    int antiDia;
    
    public TicTacToe(int n) {
        rows = new int [n];
        cols = new int [n];
    }
    
    public int move(int row, int col, int player) {
        int currPlayer = (player == 1) ? 1 : -1;
        rows[row] += currPlayer;
        cols[col] += currPlayer;
        
        if(row == col){
            diagonal += currPlayer;
        }
        
        if(col == (cols.length - row - 1)) {
            antiDia += currPlayer;
        }
        
        int n = cols.length;
        
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDia) == n) return player;
        
        return 0;
    
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */