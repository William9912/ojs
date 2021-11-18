package tests;

import java.util.*;

public class Tecent2 {
    public static void main(String[] args) {
        int len1 = 0;
        Scanner cin = new Scanner(System.in);
        String numStr;
        len1 = cin.nextInt();

        cin.nextLine();
        numStr = cin.nextLine();
        //System.out.println(numStr);
        boolean[][] dp = new boolean[len1][len1];
        int ans = len1;
        for(int i=len1-1;i>=0;--i){
            for(int len = 1;i+len<len1;len++){
                int j = i+len;
                char c1 = numStr.charAt(i);
                char c2 = numStr.charAt(j);
                int a = Integer.valueOf(c1-'0');
                int b = Integer.valueOf(c2-'0');
                //System.out.println(c1);
                if(a+b==10){
                    if(len==1){
                        dp[i][j] = true;
                        ans-=2;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                        if(dp[i][j]){
                            ans-=2;
                        }
                    }
                }

            }
        }
        System.out.println(ans);
    }
}
