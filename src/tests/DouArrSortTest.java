package tests;

//import java.lang.reflect.AccessibleObject;
import java.util.Arrays;
//import java.util.Comparator;
//
//class Arrcom implements Comparator<int[]>{
//    @Override
//    public int compare(int[] o1, int[] o2) {
//        return o1[2]-o2[2];
//    }
//}

public class DouArrSortTest {
    public static void main(String[] args) {
        int[][] nums={{2,1,3,4},{1,2,4,8},{5,1,2,8},{1,2,3,5}};
        Arrays.sort(nums,(a,b)->a[2]-b[2]);
        for(int[] x:nums){
            System.out.println(x[2]);
        }
    }
}
