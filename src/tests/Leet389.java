package tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leet389 {
    public static char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();++i){
            if(!map.keySet().contains(s.charAt(i))){
                map.put(s.charAt(i),1);
            }
            else{
                int temp = map.get(s.charAt(i));
                map.put(s.charAt(i),++temp);
            }
        }
        for(int i=0;i<t.length();++i){
            if(!map.keySet().contains(t.charAt(i))){
                return t.charAt(i);
            }
            else{
                int temp = map.get(t.charAt(i));
                map.put(t.charAt(i),--temp);
            }
        }
        for(Character c:map.keySet()){
            if(map.get(c)<0){
                return c;
            }
        }
        return 'd';
    }
    public static char findTheDifference2(String s,String t){
        char exor = 0;
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        for(char c:sarr){
            exor ^= c;
        }
        for(char c:tarr){
            exor ^= c;
        }
        return exor;
    }
    public static void main(String[] args) {
        System.out.println(findTheDifference2("sd","sdd"));

    }
}
