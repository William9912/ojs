package tests;

import java.util.Vector;

public class KMP {
    public static int kmp(String haystack, String needle){
        int k = -1, n = haystack.length(),p = needle.length();//k,已匹配的字符串，needle的下标,
        if(p==0){
            return 0;
        }
        int[] next = new int[p];
        for(int i=0;i<p;i++){
            next[i] = -1;
        }
        fail(needle,next);
        for(int i=0;i<n;++i){//i,haystack中下一个要匹配的字符
            while(k>-1&&needle.charAt(k+1) != haystack.charAt(i)){//首先k得大于-1，向next前回溯
                k = next[k];
            }
            if(needle.charAt(k+1)==haystack.charAt(i)){
                ++k;
            }
            if(k==p-1){
                return i-p+1;
            }
        }
        return -1;
    }
    public static void fail(String needle, int[] next){
        int k = -1;
        for(int i=1;i<needle.length();++i){//i是下一个要比较得字符得下标，
           while(k>-1&&needle.charAt(k+1)!=needle.charAt(i)){
                k = needle.charAt(k);
            }
            if(needle.charAt(k+1)==needle.charAt(i)){
                ++k;
            }
            next[i] = k;
        }
    }

    public static void main(String[] args) {
        String haystack = "asdfkjhajksdfhuiopnmmsdfn";
        String needle = "o";
        System.out.println(kmp(haystack,needle));
        System.out.println(haystack.indexOf(needle));
    }
}
