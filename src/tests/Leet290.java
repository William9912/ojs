package tests;

import java.util.*;

class Solution8 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        String[] arr = s.split(" ");
        if(arr.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();++i){
            if(map.keySet().contains(pattern.charAt(i))){
                if(!arr[i].equals(map.get(pattern.charAt(i)))){
                    return false;
                }
            }else{
                map.put(pattern.charAt(i),arr[i]);
            }
        }
        Set<String> set  = new HashSet<String>(map.values());

        if(map.values().size() != set.size()){
            return false;
        }
        return true;
    }
}
public class Leet290 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String pattern = cin.nextLine();
        String s = cin.nextLine();
        Solution8 so = new Solution8();
        System.out.println(so.wordPattern(pattern,s));
    }
}
