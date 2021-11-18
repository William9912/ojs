package tests;

import java.util.Stack;

public class Leet739 {
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] out = new int[T.length];
        for(int i=0;i<T.length;++i){
            out[i]=0;
            if(stack.empty()||T[i]<=T[stack.peek()]){
                stack.push(i);
                continue;
            }
            while(!stack.empty()&&T[i]>T[stack.peek()]){
                out[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return out;
    }
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] out = dailyTemperatures(T);
        for(int x:out){
            System.out.println(x);
        }
    }
}
