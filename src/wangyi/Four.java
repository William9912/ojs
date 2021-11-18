package wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Four {
    public static long convertMagicalString (String magicalString) {
        // write code here
        if(magicalString.equals("")){
            return 0L;
        }
        List<Character> alphaBetas = new ArrayList<>();
        List<Character> nums = new ArrayList<>();
        char[] arr =  magicalString.toCharArray();
        for(char c:arr){
            if('a'<=c&&c<='z'){
                alphaBetas.add(c);
            }else if('A' <= c && c<= 'Z'){
                alphaBetas.add((char)(c+32));
            }else if(Character.isDigit(c)){
                nums.add(c);
            }
        }
        Collections.sort(alphaBetas);
        Collections.sort(nums);
        StringBuilder sb = new StringBuilder();
        for(Character c:alphaBetas){
            sb.append(c);
        }
//        for(Character c:nums){
//            sb.append(c);
//        }
        String s = sb.toString();
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0;i < s.length(); ++i){
            if(i == s.length() -1){
                sb1.append(s.charAt(i)- 'a' +1);
            }else if(s.charAt(i + 1) -'a' != s.charAt(i) + 1 -'a'){
                sb1.append(s.charAt(i)- 'a' +1);
            }
        }
        for(Character c:nums){
            sb1.append(c);
        }
        return Long.valueOf(sb1.toString());
    }
    public static void main(String[] args) {
        System.out.println(convertMagicalString(""));
        //System.out.println(Long.valueOf(""));

    }
}
