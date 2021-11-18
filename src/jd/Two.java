package jd;

import java.util.*;
public class Two {
    public static boolean[][] dependent;
    public static boolean[][] beDependent;
    public static int running;
    public static boolean[] started;
    public static int n,q;
    public static void start(int x){
        if(started[x]){
            return;
        }
        else {
            started[x] = true;
            running ++;
            for(int i=0;i<n;++i){
                if(dependent[x][i]){
                    start(i);
                }
            }
        }
    }
    public static void stop(int x){
        if(!started[x]){
            return;
        }
        else {
            started[x] = false;
            running --;
            for(int i=0;i<n;++i){
                if(beDependent[x][i]){
                    stop(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        q = cin.nextInt();
        dependent  = new boolean[n][n];
        beDependent = new boolean[n][n];
        for(int i=0;i<n; ++ i){
            int c = cin .nextInt();
            for(int j=0;j< c;++j){
                int x = cin.nextInt();
                dependent[i][x -1] = true;
                beDependent[x - 1][i] = true;
            }
        }
        running = 0;
        started = new boolean[n];
        for(int i=0;i<q;++i){
            int x = cin.nextInt();
            int y = cin.nextInt();
            if(x == 1){
                start(y - 1);
            }else{
                stop( y - 1);
            }
            System.out.println(running);
        }
    }
}
