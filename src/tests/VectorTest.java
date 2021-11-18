package tests;

import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector<Integer> x = new Vector<>();
        x.add(9);
        System.out.println(x.get(0));
        x.setElementAt(220,0);
        System.out.println(x.get(0));
    }
}
