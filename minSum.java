
private long minSum(int n, int c_lib, int c_road, int[][] cities) {
    if(cities == null || cities.length == 0) return 0;
    long minSum = 0;
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    for(int [] city : cities) {
        if(!map.containsKey(city[0])){
            map.put(city[0], new ArrayList<>());
        }
        map.put(city[0], city[1]);
    }
    System.out.print(map.toString());
    return minSum;
}



rl.minSum(3, 2, 1, [[1,3], [3,1], [2,3]]);


public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
    // Write your code here
        if(cities == null || cities.size() == 0) return 0;
        long minSum = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(List<Integer> city : cities) {
            if(!map.containsKey(city.get(0))){
                map.put(city.get(0), new ArrayList<>());
            }
            map.put(city.get(0), city.get(1));
        }
        //System.out.print(map.toString());
        return minSum;     
}

