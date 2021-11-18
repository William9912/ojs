package tests;

public class KMPTest {
    public static int kmp(String haystack ,String needle) {
        int k = -1,n = haystack.length(),p = needle.length();
        int[] next = fail(needle);
        for(int i=0;i<n;++i) {
            while(k>-1&&needle.charAt(k+1)!=haystack.charAt(i)) {
                k = next[k];
            }
            if(needle.charAt(k+1)==haystack.charAt(i)) {
                k++;
            }
            if(k==p-1) {//最后一位比对完毕
                return i-p+1;
            }
        }
        return -1;
    }
    public static int[] fail(String needle) {
        int[] next = new int[needle.length()];
        for(int i=0;i<needle.length();i++) {
            next[i] = -1;
        }
        int k = -1, p = needle.length();//对于字符串abnab,k代表1，即第一个b得下标
        for(int i=1;i<p;++i) {
            while(k>-1&&needle.charAt(k+1)!=needle.charAt(i)) {//递归过程
                k = next[k];
            }
            if(needle.charAt(k+1)==needle.charAt(i)) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }
    public static void main(String[] args) {
        String haystack = "bhbsbhfbhbhbhbjkbhkkkkbuikbhhhhhkb";
        String needle = "uikbhhhhh";
        System.out.println(kmp(haystack,needle));
        System.out.println(haystack.indexOf(needle));
    }
}