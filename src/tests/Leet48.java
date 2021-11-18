package tests;

public class Leet48 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0;i<matrix.length/2;++i){
            for(int j=i;j<n-1;++j){

                int a = matrix[i][j];
                int b = matrix[j][matrix.length-1-i];
                int c = matrix[matrix.length-1-i][n-1-j];
                int d = matrix[n-1-j][i];
                matrix[i][j] = d;
                matrix[j][matrix.length-1-i] = a;
                matrix[matrix.length-1-i][n-1-j] =b;
                matrix[n-1-j][i] = c;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrx = {{1,2,3},{4,5,6},{7,8,9}};
        for(int i=0;i<matrx.length;++i){
            for(int j = 0;j<matrx.length;++j){
                System.out.print(matrx[i][j] + " ");
            }
            System.out.println();
        }
        rotate(matrx);
        System.out.println();
        for(int i=0;i<matrx.length;++i){
            for(int j = 0;j<matrx.length;++j){
                System.out.print(matrx[i][j] + " ");
            }
            System.out.println();
        }
    }
}
