import java.util.*;

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<String> li = new ArrayList<>();
        if(s == null || s.length() == 0) return 0;
        int slow = 0; int max = 0;
        int curr = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, i+1);
            curr = i - slow + 1;
            if(curr > max){
                li = new ArrayList<>();
                li.add(s.substring(slow, i+1));
                max = curr;
            } else {
                li.add(s.substring(slow, i+1));
            }
        }
        System.out.println(Arrays.toString(li.toArray()));;
        return max;
    }
}