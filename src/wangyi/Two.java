package wangyi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Two {
    public static int solve(int[] arr, int index){
        if(index == 0){

            return 0;
        }
        if(arr[index] > 1){
            arr[index - 1] += (arr[index]-1);
            return solve(arr, index-1) + (arr[index]-1);
        }
        return solve(arr, index - 1);
    }
    public static int minDeletions (String s) {
        // write code here
        int[] store = new int[26];
        for(int i=0;i<s.length();++i){
            store[s.charAt(i)-'a'] ++;
        }
        Map<Integer,Integer> map =new HashMap<>();
        for(int i:store){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        List<Integer> list = (List<Integer>) map.values();
        int[] arr = new int[list.size()];
        return solve(arr, 25);
    }
    public static void main(String[] args) {
        System.out.println(minDeletions("ceabaacb"));
    }
}
