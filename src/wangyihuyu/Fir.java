package wangyihuyu;

import java.util.*;
public class Fir{
    public static int[] jundge(int a,int b,int[][] arr,int i,int preHea){
        int[] ans = new int[2];
        if(arr[i][1]>=a){
            return null;
        }
        int eniH = arr[i][2];
        int myHea = 0;
        int count = 0;
        while(eniH > 0){
            if(count %2==0){
                if(eniH - (a-arr[i][1])<=0){
                    ans[1] = (a-arr[i][1])-eniH;
                }

                eniH -= (a-arr[i][1]);
            }
            else{
                if((arr[i][0] - b) > 0){
                    myHea -= (arr[i][0] - b);
                }
            }
            count ++;
        }
        //System.out.println("i:"+i);
        //System.out.println("MyHea:"+myHea);
        //System.out.println("PreH:"+ preHea);
        ans[0] = -myHea - preHea;
        //System.out.println("ans[0]:"+ans[0]);
        return ans;
    }
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for(int i=0;i<T;++i){
            int N = cin.nextInt();
            int A = cin.nextInt();
            int B = cin.nextInt();
            int[][] arr = new int[N][3];
            for(int j=0;j<N;++j){
                arr[j][0] = cin.nextInt();
                arr[j][1] = cin.nextInt();
                arr[j][2] = cin.nextInt();
            }
            int preHea = 0;
            int re = 1;
            int t = 1;
            for(int j=0;j<N;++j){

                int[] temp = jundge(A,B,arr,j,preHea);

                if(temp == null){
                    System.out.println(-1);
                    break;
                }
                t+=temp[0];
                re = Math.max(re,t);
                if(j == N -1 ){
                    System.out.println(re);
                }
                preHea = temp[1];

            }
        }
    }
}