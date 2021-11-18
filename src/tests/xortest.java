package tests;

public class xortest {
    public static void main(String[] args) {
        char out='a';
        int[] x;
        
        char temp = (char) (out^ 'b');
        char end = (char) (temp^out);
        System.out.println(end);
    }
}
