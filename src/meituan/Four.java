package meituan;

import java.util.*;
public class Four {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n,m,x,y;
        n = cin.nextInt();
        m = cin.nextInt();
        x =  cin.nextInt();
        y = cin.nextInt();
        int[][] mapMan = new int[n][n];
        int[][] mapCar = new int[n][n];
        for(int[] arr:mapCar){
            Arrays.fill(arr,-1);
        }
        for(int[] arr:mapMan){
            Arrays.fill(arr,-1);
        }
        for(int i=0;i<m;++i){
            int x1 = cin.nextInt();
            int y1 = cin.nextInt();
            int p = cin.nextInt();
            int q = cin.nextInt();
            mapMan[x1-1][y1-1] = q;
            mapMan[y1-1][x1-1] = q;
            mapCar[x1-1][y1-1] = p;
            mapCar[y1-1][x1-1] = p;
        }

        int[] wait = new int[n];
        for(int i=0;i<n;++i){
            wait[i] = cin.nextInt();
        }
        int[][] timeCar = new int[n][n];
        int[][] timeMan = new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                timeCar[i][j] = -1;

                timeMan[i][j] = -1;

            }
        }
        for(int i=0;i<n;++i){
            timeCar[i][i] = 0;
            timeMan[i][i] = 0;
        }
        for(int j=0;j<n;++j){
            for(int i=0;i<n;++i){
                timeCar[i][j] = mapCar[i][j];
                timeMan[i][j] = mapMan[i][j];
            }
        }


        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                for(int k=0;k<n;++k){
                    if(mapCar[i][j]!=-1&&mapCar[i][k]!=-1){
                        if(timeCar[k][j] == -1){
                            timeCar[k][j] = timeCar[j][k] =mapCar[i][j]+mapCar[i][k];
                        }
                        else{
                            timeCar[k][j] = Math.min(mapCar[i][j]+mapCar[i][k],timeCar[k][j]);
                        }
                    }
                    if(mapMan[i][j]!=-1&&mapMan[i][k]!=-1){
                        if(timeMan[k][j] == -1){
                            timeMan[k][j] = timeMan[j][k] =mapMan[i][j]+mapMan[i][k];
                        }
                        else{
                            timeMan[k][j] = Math.min(mapMan[i][j]+mapMan[i][k],timeMan[k][j]);
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;++i){
            ans = Math.min(ans, Math.max(wait[i],timeMan[x-1][i])+timeCar[i][y-1]);
        }
        ans = Math.min(ans,timeMan[x-1][y-1]);
        System.out.println(ans);
    }
}
