package tests;

public class TXie1 {
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
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ac";
        System.out.println((int)'z');
        System.out.println((int)'c');
        System.out.println((int)'b');
        System.out.println(cal(s1,s2));
    }
}