package tests;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

class A{
    int x;
    int y;
}
public class LambdaTest {
    public static void main(String[] args) {
        A[] arr =new A[2];
        A a = new A();
        a.x = 1;
        a.y = 2;
        A b = new A();
        b.y = 1;
        b.x = 2;
        arr[0] = b;
        arr[1] = a;
        Set<A> set = new TreeSet<A>((c,d)->c.x-d.y);
        set.add(b);
        set.add(a);
        System.out.println("length:");
        System.out.print(set.size());
        for(A t: set){
            System.out.print(t.x);
            System.out.print(" ");
            System.out.print(t.y);
            System.out.println();
        }
//        Arrays.sort(arr,(c,d)->c.x-d.x);
//        for(A t:arr){
//            System.out.print(t.x);
//            System.out.print(" ");
//            System.out.print(t.y);
//            System.out.println();
//        }
    }
}
