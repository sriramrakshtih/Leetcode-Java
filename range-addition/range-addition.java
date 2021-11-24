class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        
        int [] arr = new int [length];
        if(updates == null || updates.length == 0) return arr;
        for(int [] update : updates) {
            for(int start = update[0]; start <= update[1]; start++) {
                arr[start] += update[2];
            }
        }
        
        return arr;
    }
}