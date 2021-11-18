package tests;

public class Leet331 {
    public static int buildTree(String s,int i){
        if(i==s.length()){
            return -1;
        }
        if(i>s.length()){
            return -2;
        }
        if(s.charAt(i)=='#'){
            return i+1;
        }
        int next = buildTree(s,i+1);
        if(next<0){
            return -2;
        }
        int next1 = buildTree(s,next);
        return next1;
    }
    public static boolean isValidSerialization(String preorder) {
        preorder = preorder.replaceAll(",","");
        if(buildTree(preorder,0)==-1){
            return true;
        }
        //System.out.println(buildTree(preorder,0));
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}