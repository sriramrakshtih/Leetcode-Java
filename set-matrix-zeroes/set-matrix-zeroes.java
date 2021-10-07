class Solution {
    public void setZeroes(int[][] matrix) {
        int [][] mat = new int[matrix.length][matrix[0].length];
        Stack<List<Integer>> st = new Stack<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++){
                int row = 0; int col = 0;
                if(matrix[i][j] == 0){
                    st.push(List.of(i, j));
                }
            }
        }
        while(!st.isEmpty()){
            List<Integer> idxs = st.pop();
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    if(i == idxs.get(0)){
                        matrix[i][j] = 0;
                    }
                    if(j == idxs.get(1)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}