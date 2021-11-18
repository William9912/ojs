package tests;

class Solution9{
    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        char[] arr = str.toCharArray();
        int max = -1,index = -1;
        for(int i=0;i<str.length()-1;++i){
            if(str.charAt(i)>max){
                index = i;
                max = str.charAt(i);
            }
            if (str.charAt(i) > str.charAt(i + 1)) {
                arr[index] -=1;
                for(int j=index+1;j<str.length();++j){
                    arr[j]='9';
                }
                break;
            }
        }
        return Integer.valueOf(new String(arr));
    }
}
public class Leet738 {
    public static void main(String[] args) {
        int x = 324;
        System.out.println(new Solution9().monotoneIncreasingDigits(x));
    }
}
