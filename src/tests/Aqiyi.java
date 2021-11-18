package tests;

import java.util.Scanner;

public class Aqiyi {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        String[] arr1 = str.split(":");
        String[] numArr = arr1[0].split(",");
        int[] nums = new int[numArr.length];
        int index = 0;
        for(String num:numArr){
            nums[index++] = Integer.valueOf(num);
        }
        int k = Integer.valueOf(arr1[1]);
        float total = 0;
        for(int i=0;i<k;++i){
            total+= nums[i];
        }
        float before = total;
        float maxR = 0;
        float nowR = 0;
        for(int i=k;i<nums.length;++i){

            total+= nums[i];
            total-=nums[i-k];
            float nowAvg= total/k;
            float beforeAvg = before/k;
            nowR = Math.max(nowAvg,beforeAvg)/Math.min(nowAvg,beforeAvg);
            nowR-=1;
            if(total<before){
                nowR = -nowR;
            }
//            System.out.println("nowTotal:"+total);
//            System.out.println("nowAvg"+nowAvg);
//            System.out.println("beforeAvg"+beforeAvg);
//            //System.out.println(total);
//            System.out.println("nowR"+nowR);
            if(i==k){
                maxR = nowR;
            }else{
                maxR = Math.max(nowR,maxR);
            }
            before = total;
        }
        String ans = String.format("%.4f",maxR);
        String[] ansArr = ans.split("[.]");
        String ans1 = "";
        if(!"0".equals(ansArr[0])){
            ans1+=ansArr[0];
        }
        ans1+=ansArr[1].substring(0,2);
        ans1+=".";
        ans1+=ansArr[1].substring(2,4);
        ans1 +="%";
        System.out.println(ans1);
    }
}
