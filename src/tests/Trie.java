package tests;

public class Trie {
    public static int[][] trie;
    public static int k;
    public static int[] colorNode;
    public static void init(int maxNodeNum,int charSetNum){
        trie = new int[maxNodeNum][charSetNum];
        k = 1;
        colorNode = new int[maxNodeNum];
    }
    public static void insert(String str){
        int p=0;
        for(int i=0;i<str.length();++i){
            int c = str.charAt(i)-'a';
            if(trie[p][c]==0){
                trie[p][c] = k;
                k++;
            }
            p = trie[p][c];
        }
        colorNode[p] = 1;
    }
    public static boolean search(String str){
        int p=0;
        for(int i=0;i<str.length();++i){
            int c = str.charAt(i)-'a';
            if(trie[p][c]==0){
                return false;
            }
            p = trie[p][c];
        }
        return colorNode[p] ==1;
    }

    public static void main(String[] args) {
        init(1000000,26);
        String[] arr = {"in","inn","innn","it","yasuo","yamazaki","its"};
        for(String s:arr){
            insert(s);
        }
        for(String s:arr){
            System.out.println(search(s));
        }
        //System.out.println(search("yasuo"));
        System.out.print(search("zhaoxin"));
    }
}
