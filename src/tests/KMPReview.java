package tests;


import javax.print.DocFlavor;
import java.util.Vector;

public class KMPReview {
    public static int kmp(String pad ,String needle) {
        int k=-1;
        int[] next = fail(needle);
        for(int i=0;i<pad.length();++i){
            while(k>-1&&needle.charAt(k+1)!=pad.charAt(i)){
                k = next[k];
            }
            if(needle.charAt(k+1)==pad.charAt(i)){
                ++k;
            }
            if(k==needle.length()-1){
                return i-needle.length()+1;//返回最早的下标
            }
        }
        return -1;
    }
    public static Vector<Integer> kmp2(String pad, String needle){
        int k=-1;
        Vector<Integer> out = new Vector<>();
        int[] next = fail(needle);
        for(int i=0;i<pad.length();++i){

            while(k>-1&&needle.charAt(k+1)!=pad.charAt(i)){
                k = next[k];
            }
            if(needle.charAt(k+1)==pad.charAt(i)){
                ++k;
            }
            if(k==needle.length()-1){
                out.add(i-needle.length()+1);
                k=-1;
            }
        }
        return out;
    }
    public static int[] fail(String needle){
        int[] out = new int[needle.length()];
        for(int i=0;i<needle.length();++i){
            out[i]=-1;
        }
        int k=-1;
        for(int i=1;i<needle.length();++i){
            while(k>-1&&needle.charAt(k+1)!=needle.charAt(i)){
                k = out[k];
            }
            if(needle.charAt(k+1)==needle.charAt(i)){
                ++k;
            }
            out[i] = k;
        }
        return out;
    }
    public static void main(String[] args) {
        String needle = "asd";
        String pad = "asdfiasd";
        Vector<Integer> x = kmp2(pad,needle);
        for(int o:x){
            System.out.print(o+" ");
        }
    }
}
