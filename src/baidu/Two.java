package baidu;

import java.util.*;
public class Two {
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a % b);
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for ( int i=0; i < T ; i ++){
            int N = cin .nextInt();
            int sub = (int) Math.sqrt(N);
            int ans = 1;
            for (int j = 2; j <= sub;j ++){
                if(N % j == 0){
                    int k = N / j;
                    if(gcd(k,j) == 1){
                        ans ++;
                    }
                }
            }
            System.out.print(ans);
            if(i != T - 1){
                System.out.println();
            }
        }
        cin.close();
    }
}
