class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if(startTime.length != endTime.length) return -1;
        int count = 0;
        for(int i = 0; i < startTime.length; i++) {
            if(startTime[i] < queryTime && endTime[i] >= queryTime || startTime[i] == queryTime){
                count++;
            }
        }
        return count;
    }
}