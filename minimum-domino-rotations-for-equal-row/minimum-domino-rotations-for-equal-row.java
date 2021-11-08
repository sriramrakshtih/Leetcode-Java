class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0; int max = -1;
        for(int i = 0; i < tops.length; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(tops[i]));
            if(maxFreq >= tops.length) {
                max = tops[i];
                break;
            }
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(bottoms[i]));
            if(maxFreq >= bottoms.length) {
                max = bottoms[i];
                break;
            }
        }
        
        if(max == -1) return -1;
        int aRot = 0, bRot = 0;
        for(int i = 0; i < tops.length; i++) {
            if(tops[i] != max && bottoms[i] != max) return -1;
            if(tops[i] != max) aRot++;
            if(bottoms[i] != max) bRot++;
        }
        
        return Math.min(aRot, bRot);
        
    }
}