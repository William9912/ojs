package meituan;
import java.util.*;
public class Fir {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for(int i=0; i< t; ++i){
            int n = cin.nextInt();
            int[] arr = new int[n];
            for(int j=0;j<n;++j){
                int num = cin.nextInt();
                if(num <= n){
                    arr[num - 1] = 1;
                }

            }
            boolean flag = false;
            for(int j=0;j<n;++j){
                if(arr[j] == 0){
                    System.out.println("No");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("Yes");
            }

        }
    }


}
