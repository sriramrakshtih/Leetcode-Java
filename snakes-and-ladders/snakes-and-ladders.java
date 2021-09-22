class Solution {
    public int snakesAndLadders(int[][] board) {
        int r = board.length;
        int [] moves = new int[r*r];
        int i = r - 1;
        int j = 0;
        int even = 0;
        int idx = 0;
        int minMoves = 0;
        
        while(i >= 0 && j >= 0) {
            if(board[i][j] == -1) {
                moves[idx] = -1;
            } else {
                moves[idx] = board[i][j] - 1;
            }
            idx++;
            
            if(even % 2 == 0) {
                j++;
            } else {
                j--;
            }
            
            if(j == r){
                i--;
                j--;
                even++;
            }
            if(j < 0){
                i--;
                j++;
                even++; 
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0); moves[0] = -2;
        while(!q.isEmpty()){
            int size = q.size();
            for(int l = 0; l < size; l++) {
                int curr = q.poll();
                for(int k = 1; k <= 6; k++){
                    if(curr == moves.length - 1) return minMoves;
                    int baby = curr + k;
                    if(baby <= moves.length - 1 && moves[baby] != -2){
                        if(moves[baby] == -1){
                            q.add(baby);
                        } else {
                            q.add(moves[baby]);
                        }
                        moves[baby] = -2;    
                    }
                }
            }
            minMoves++;
        }
        return -1;
    }
}