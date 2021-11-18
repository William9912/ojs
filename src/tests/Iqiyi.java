package tests;
import  java.util.*;
public class Iqiyi {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        str = str.substring(1,str.length()-1);
        String[] arr = str.split(",");
        int[] nums = new int[arr.length];
        int index = 0;
        for(String s:arr) {
            nums[index++] = Integer.valueOf(s);
        }
        int[] ans = new int[nums.length];
        int[] lakes = new int[nums.length];
        for(int i=0;i<nums.length;++i){
            if(nums[i]>0){
                if(lakes[nums[i]-1]==1){
                    System.out.println("[]");
                    return;
                }
                lakes[nums[i]-1] = 1;
                ans[i] = -1;
            }else{
                int j = i+1;
                boolean flag = false;
                while(j<nums.length){
                    if(nums[j]>0&&lakes[nums[j]-1]==1){
                        flag = true;
                        lakes[nums[j]-1] = 0;
                        ans[i] = nums[j];
                        break;
                    }
                    ++j;
                }
                if(!flag){
                    ans[i] = 1;
                }
            }
        }
        String out = "";
        out+="[";
        for(int i:ans){
            out+=i;
            out+=",";
        }
        out = out.substring(0,out.length()-1);
        out+="]";
        System.out.println(out);
    }
}
