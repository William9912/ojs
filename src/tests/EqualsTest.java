package tests;

public class EqualsTest {
    public static void main(String[] args) {
        int i=1;
        //i=++i+i++;
        i= i++ + ++i;
        System.out.println(i);
    }

}