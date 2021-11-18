package tests;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XieTwo {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    public static  int cal(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;++i){
            dp[i][0] = dp[i-1][0]+(int)(s1.charAt(i-1));
        }
        for(int i=1;i<m+1;++i){
            dp[0][i] = dp[0][i-1]+(int)(s2.charAt(i-1));
        }
        for(int i=1;i<n+1;++i){
            for(int j=1;j<m+1;++j){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]+(int)s1.charAt(i-1)),dp[i][j-1]+(int)s2.charAt(j-1));
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+(int)s1.charAt(i-1),dp[i][j-1]+(int)s2.charAt(j-1));
                }
            }
        }
        return dp[n][m];
    }
    static int calcSimilarity(String name1, String name2) {
        String[] arr1 = name1.split(" ");
        String[] arr2 = name2.split(" ");
        String[] longer;
        String[] shorter;
        int ans = 0;
        int len;
        if(arr1.length<arr2.length){
            len = arr1.length;
            int index = arr1.length;
            ans = 0;
            while(index<arr2.length){
                for(int j = 0;j<arr2[index].length();++j){
                    ans+=(int)arr2[index].charAt(j);
                }
                index++;
            }
        }else if(arr1.length>arr2.length){
            len = arr2.length;
            int index = arr2.length;
            ans = 0;
            while(index<arr1.length){
                for(int j = 0;j<arr1[index].length();++j){
                    ans+=(int)arr1[index].charAt(j);
                }
                index++;
            }
        }else{
            len = arr1.length;
        }
        for(int i = 0;i<len;++i){
            ans += cal(arr1[i],arr2[i]);
        }
        return ans;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String name1 = in.nextLine();
            String name2 = in.nextLine();

            int sum = calcSimilarity(name1, name2);
            System.out.println(sum);
        }
    }
}
