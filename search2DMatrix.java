public class search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int m = matrix.length; int n = matrix[0].length;
        int i = m-1; int j = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
