class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int unitsCount = 0;
        for(int [] boxes : boxTypes) {
            int boxCount = Math.min(truckSize, boxes[0]);
            unitsCount += boxCount * boxes[1];
            truckSize -= boxCount;
            if(truckSize == 0) break;
        }
        return unitsCount;
    }
}