package alibaba;
import  java.util.*;

public class Ali1 {


    public static boolean legal(int x, int y, int n){
        return x<n&&x>=0&&y>=0&&y<3;
    }
    public static long out1;
    public  static  void ch(int[][] t,int i,int j){
        if(i > t.length-1||j>2){
            out1++;
            for(int [] a:t){
                for(int b:a){
                    System.out.print(b);
                    System.out.print(" ");
                }
                System.out.println();
            }
            return;
            //out1%=(Math.pow(10,9)+1);
        }
        System.out.println();
        for(int x=1;x<=3;++x){
            boolean flag = true;
            if(legal(i-1,j,t.length)){
                if(t[i-1][j]==x){
                    flag = false;
                }
            }
            if(legal(i,j-1,t.length)){
                if(t[i][j-1]==x){
                    flag = false;
                }
            }
            if (flag){
                int nextj  = j+1;
                int rj = nextj%3;
                int ri = i+ nextj/3;
                t[i][j] = x;
                ch(t,ri,rj);
                t[i][j] = 0;
            }
        }
    }
    public static long clu(int n){
        int[][] g = new int[n][3];
        ch(g,0,0);
        //out1%=(Math.pow(10,9)+1);
        return out1;
    }
    public static void main(String[] args) {
        int t;
        Scanner cin = new Scanner(System.in);
        t = cin.nextInt();
        //[] arr = new int[t];
        for(int i=1;i<=t;++i){
            //arr[i] = cin.nextInt();
            int temp = cin.nextInt();
            out1 = 0;
            System.out.println(clu(temp));
        }
    }
}
