package tests;

import java.util.PriorityQueue;

public class PriorityQLambda {
    public static void main(String[] args) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int [] a = {1,2};
        int[] b = {2,1};
        q.add(a);
        q.add(b);
        for(int[] c:q){
            System.out.println(c[1]);
        }
    }
}
