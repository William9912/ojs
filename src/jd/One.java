package jd;

import java.util.*;
public class One {
    public static void main(String[] args) {
        int n,m,x,y,z;
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        x = cin.nextInt();
        y = cin.nextInt();
        z = cin.nextInt();
        char[][] grad = new char[n][m];
        String s = cin.nextLine();
        for(int i=0;i<n;++i){
            String str = cin.nextLine();
            char[] arr = str.toCharArray();
            //System.out.println("asdfasdf"+arr.length + " " + str);
            grad[i] = arr;
        }
        String target = cin.nextLine();
        Map<Character, int[]> map = new HashMap<>();
        for(int i = 0; i < n;++i){
            for(int j=0 ;j < m; ++j){
                int[] arr = {i,j};
                //System.out.println(grad.length);
                //System.out.println(grad[0].length);
                map.put(grad[i][j], arr);
            }
        }
        char[] tar = target.toCharArray();
        int ans = 0;
        int nowx = 0;
        int nowy = 0;
        for(char c:tar){
            int[] arr = map.get(c);
            int moveCost = (Math.abs(arr[0] - nowx) + Math.abs(arr[1] - nowy)) * x;
            int change = 0;
            if(arr[0] != nowx && arr[1] != nowy){
                change = y;
            }
            nowx = arr[0];
            nowy = arr[1];
            System.out.println("moveCost "+ moveCost);
            ans += (moveCost + change + z);
            System.out.println(c + " " + ans);
        }
        System.out.println(ans);
    }
}
