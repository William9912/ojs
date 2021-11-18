package meituan;
import java.util.*;
public class Sec {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        int n = s.length();
        int max = 0;
        for(int i=0;i<n;++i){
            int index = i;
            int right = n-1;
            while(index <= right){
                if(s.charAt(index) == s.charAt(right)){
                    index++;
                    right --;
                }else{
                    break;
                }
            }
            if(index>right){
                max = n-i;
                break;
            }
        }
        System.out.println(n-max);
    }
}
