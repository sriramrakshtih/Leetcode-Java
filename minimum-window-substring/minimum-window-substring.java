class Solution {
    public String minWindow(String str, String pattern) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
          char c = pattern.charAt(i);
          map.put(c, map.getOrDefault(c, 0) + 1);
        }

       

        int left = 0; int minLen = Integer.MAX_VALUE;
        int count = 0; int head = 0;

        for(int i = 0; i < str.length(); i++) {
          char c = str.charAt(i);
          if(map.containsKey(c)){
            map.put(c, map.get(c) - 1);
            if(map.get(c) == 0) {
              count++;
            }
          }

          if(count == map.size()) {
            while(true) {
              char cl = str.charAt(left);
              if(map.containsKey(cl) && map.get(cl) < 0) {
                map.put(cl, map.get(cl) + 1);
                left++;
              } else if(!map.containsKey(cl)) {
                left++;
              } else {
                break;
              }
            }
            if(i - left + 1 < minLen) {
                head = left;
                minLen = i - left + 1;
            }
          }
        }
        return minLen == Integer.MAX_VALUE ? "" : str.substring(head, head + minLen);
    }
}