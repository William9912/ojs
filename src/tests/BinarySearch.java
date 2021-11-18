package tests;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8,12,23,34,45,46,65,67};
        int i = 0;
        int j = arr.length;
        int target = 8;
        while(i<j){
            int mid = i+(j-i)/2;
            if(arr[mid]==target){
                System.out.println(mid);
                return;
            }else{
                if(arr[mid]<target){
                    i = mid+1;
                }else {
                    j = mid;
                }
            }
        }
        System.out.println(-1);
    }
}
