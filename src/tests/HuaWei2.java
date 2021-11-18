package tests;

import java.util.*;
public class HuaWei2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //int[] arr = new int[1000];
        int index = 0;
        String s = cin.nextLine();
        cin.close();
        String s1 = s.substring(1,s.length()-1);
        if(s1.length()==0){
            System.out.println(0);
            return;
        }
        String[] arrs = s1.split(", ");
        int[] arr = new int[arrs.length];
        for(String st:arrs){
            arr[index++] = Integer.valueOf(st);
        }
        //Arrays.sort(arr);
        int ans = 0;
        boolean[] vised = new boolean[1000];
        for(int i:arr){
            if(!vised[i]){
                vised[i] = true;
                ans+=i+1;
            }
        }
        System.out.println(ans);
    }
}
