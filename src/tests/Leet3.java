import java.util.HashMap;
import java.util.*;
import java.lang.Math;

public class Leet3 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int begin=0;
        int end = 0;
        int ans = 0;
        for(;end<s.length();++end){
            if(map.containsKey(s.charAt(end))){
                begin = Math.max(begin,map.get(s.charAt(end)));
            }
            map.put(s.charAt(end), end+1);
            ans = Math.max(ans, end-begin+1);
        }
        return ans;
    }
}
