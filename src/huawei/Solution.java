package huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static int caculate(String s){
        int ans = 0;
        s = s.replaceAll(" ","");
        Stack<Integer> stack = new Stack<>();
        char before = '+';
        for(int i=0; i < s.length();i++){
            int num = 0;
            int index = i;
            while('0'<=s.charAt(i)&&s.charAt(i) <='9' &&  i<s.length() - 1){
                i++;
            }
            String s1 = s.substring(index,i);
            num = Integer.valueOf(s1);
            if(before == '+'){
                stack.push(num);
            }
            else if (before == '-'){
                stack.push(-num);
            }else if (before == '*'){
                int x = stack.pop();
                stack.push(x * num);
            }else {
                stack.push(stack.pop() / num);
            }
            if(i < s.length()){
                before = s.charAt(i);
            }
        }
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(caculate(s));
    }
}
