import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap <Character, Character> smap = new HashMap<>();
        HashMap <Character, Character> tmap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            if(smap.containsKey(sc)){
                if(smap.get(sc) != tc) return false;
            } else {
                smap.put(sc, tc);
            }
            if(tmap.containsKey(tc)){
                if(tmap.get(tc) != sc) return false;
            } else {
                tmap.put(tc, sc);
            }   
        }
        return true;
    }
}
