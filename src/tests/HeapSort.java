package tests;

public class HeapSort {
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] = temp;
    }
    public static void sink(int[] nums, int root,int k){
        while((root<<1)<=k){
            int j = 2*root;
            if(j+1<=k&&nums[j+1] > nums[j]){
                j++;
            }
            if(nums[root] < nums[j]){
                swap(nums,root,j);
            }else {
                break;
            }
            root = j;
        }
    }
    public static void heapSort(int[] nums){
        int[] cp = new int[nums.length + 1];
        for(int i=0;i<nums.length;++i){
            cp[i+1] = nums[i];
        }
        int n = nums.length;
        for(int i = n / 2;i>=1;i--){//第一次全体下沉，找出最大的
            sink(cp,i,n);
        }
        int index = n;
        while(index>1){//按大小交换
            swap(cp, index, 1);
            sink(cp,1,--index);
        }
        for(int i=1;i<=n;++i){
            nums[i-1] = cp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,9,7,5,7,4,12,8,7,45,7,5,-1,4,6,3,7,2,7,9};
        heapSort(nums);
        for(int k:nums){
            System.out.println(k);
        }
    }
}
