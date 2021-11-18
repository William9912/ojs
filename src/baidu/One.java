package baidu;
import java.util.*;
public class One {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int K = cin.nextInt();
        int[][] arr = new int[N][N];
        for(int i=0; i < N;++i){
            for(int j = 0; j < N;++j){
                arr[i][j] = cin.nextInt();
            }
        }
        int total = N * K;
        int[][] ans = new int[N * K][total];
        for(int i=0; i < N;++i){
            for(int j = 0; j < N;++j){
                int toX = i * K;
                int toY = j * K;
                for(int m=0;m<K;++m){
                    for(int n=0;n<K;++n){
                        ans[toX + m][toY + n] = arr[i][j];
                    }
                }
            }
        }
        for(int i=0;i<total;++i){
            for(int j=0;j<total;++j){
                System.out.print(ans[i][j]);
                if(i != total - 1 || j != total - 1){
                    System.out.print(" ");
                }
            }
            if(i != total - 1){
                System.out.println();
            }
        }
        cin.close();
    }
}
