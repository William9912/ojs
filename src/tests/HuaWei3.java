package tests;

import java.util.*;
public class HuaWei3 {
    public static int[][] dp;
    public static String s1;
    public static String s2;
    public static int index;
    public static int minDis(int i,int j){
        return Math.min(Math.max(i,j)-Math.min(i,j),Math.min(i,j)+s1.length()-Math.max(i,j));
    }
    public static int dp1(int i,int j){
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        //List<Integer> indexscur = new ArrayList<>();
        List<Integer> indexspre = new ArrayList<>();
//        for(int k=0;k<s1.length();++k){
//            if(s1.charAt(k)==s2.charAt(j)){
//                indexscur.add(k);
//            }
//        }
        if(i==0){
            indexspre.add(index);
        }else{
            for(int k=0;k<s1.length();++k){
                if(s1.charAt(k)==s2.charAt(i-1)){
                    indexspre.add(k);
                }
            }
        }
        //for(int t:indexscur){
            if(i==0){
                dp[i][j] = Math.min(dp[i][j],minDis(j,index));
            }else{
                for(int k:indexspre){
                    dp[i][j] = Math.min(dp[i][j],minDis(j,k)+dp1(i-1,k));
                }
            }
        //}
        return dp[i][j];
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        s1 = cin.nextLine();
        s2 = cin.nextLine();
        index = cin.nextInt();
         dp = new int[s2.length()][s1.length()];
         for(int[] a:dp){
             Arrays.fill(a,Integer.MAX_VALUE);
         }
         //input:maooooa am 4
         int ans = Integer.MAX_VALUE;
         for(int i=0;i<s1.length();++i){
             if(s1.charAt(i)==s2.charAt(s2.length()-1)){
                 ans = Math.min(ans,dp1(s2.length()-1,i));
             }
         }
         System.out.println(ans);
    }
}
