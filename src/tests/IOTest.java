package tests;

import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String x = cin.nextLine();
        String[] arr = x.split("a");
        for(String s:arr){
            System.out.println(s);
        }

    }
}
