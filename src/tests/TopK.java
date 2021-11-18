package tests;

public class TopK {
    public static int part(int[] arr,int i,int j){
        if(i+1>=j){
            return i;
        }
        int val = arr[i],left = i,right = j-1;
        while(left<right){
            while(left<right&&arr[right]<=val){
                right--;
            }
            arr[left] = arr[right];
            while(left<right&&arr[left]>=val){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = val;
        return left;
    }
    public static int topK(int[] arr,int K){
        int index = part(arr,0,arr.length);
        int i=0;
        int j = arr.length;
        while (index+1!=K){
            if(index+1<K){
                i = index+1;
                index = part(arr,i,j);
            }else{
                j = index;
                index = part(arr,i,j);
            }
        }
        return arr[K-1];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,6,3,7,8};
        //System.out.println(topK(arr,3));
        int a = topK(arr,2);
        System.out.println(a);
//        System.out.println();
//        for(int i:arr){
//            System.out.println(i);
//        }
    }
}
