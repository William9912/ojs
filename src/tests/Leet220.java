package tests;

import com.sun.source.tree.Tree;

import java.util.*;

public class Leet220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;++i){
            int small = nums[i]-t;
            if(map.ceilingKey(small)!=null&&map.ceilingKey(small)<=nums[i]){
                if(i-map.get(map.ceilingKey(small))<=k){
                    return true;
                }
            }
            int big = t+nums[i];
            if(map.floorKey(big)!=null&&map.floorKey(big)>=nums[i]){
                if(i-map.get(map.floorKey(big))<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return  false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int[] arr1 = {1,0,1,1};
        int[] arr2 = {1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate(arr2,2,3));
    }
}
