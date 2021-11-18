package tests;

import java.util.TreeMap;
import java.util.TreeSet;

public class Leet1 {
    //public static int num1;
//    public static int leftUp(int num,int level){
//        if(level==0){
//            return 1;
//        }
//        else{
//            //上一层的尾巴加一
//            int  end = last(num,level-1,leftUp(num,level-1))+1;
//            return end==10? 1:end;
//        }
//    }
//    public static int last(int num,int level,int begin){
//        int thisLevelNum = num-2*level;
//        int n = 4*thisLevelNum-4;
//        if(9-begin+1>=n){//
//            return begin-1+n;
//        }else{
//            int ans = (n-(9-begin+1))%9;
//            return ans==0? 9:ans;
//        }
//    }
    public static int orchestraLayout(int num, int xPos, int yPos) {
        //目标点所在层数
        int level = Math.min(xPos-0,Math.min(num-1-xPos,Math.min(yPos-0,num-1-yPos)));
        //最外层层多少个数
        int thisLevelNum = num-2*level;
        int curLevNum = num;
        int ntemp = 4*curLevNum-4;
        int preBegin = 1;//第一层开始结点
        int preEnd;//第一层结束结点
        if(9-preBegin+1>=ntemp){//不够捋到9
            preEnd = preBegin-1+ntemp;
        }else{
            int ans = (ntemp-(9-preBegin+1))%9;
            preEnd = (ans==0? 9:ans);
        }
        for(int i=1;i<=level;++i){
            preBegin = (preEnd+1)%9;
            if(preBegin==0){
                preBegin = 9;
            }
            curLevNum-=2;
            ntemp = 4*curLevNum-4;
            if(9-preBegin+1>=ntemp){//
                preEnd = preBegin-1+ntemp ;
            }else{
                int ans = (ntemp-(9-preBegin+1))%9;
                preEnd = (ans==0? 9:ans);
            }
        }
        int leftup = preBegin;
        //int leftup = leftUp(num, level);
        if(xPos==level||yPos == num-1-level){//在上右两条边上
            int ans = (leftup+(xPos-level)+yPos-level)%9;
            return ans==0? 9:ans;
        }else{//在左下两条边上
            int ans = (leftup+(thisLevelNum-2)+thisLevelNum+(level+thisLevelNum-1-xPos)+(level+thisLevelNum-1-yPos))%9;
            return ans==0? 9:ans;
        }
    }

    public static void main(String[] args) {
        //orchestraLayout(5,0,0);
        //System.out.print(leftUp(2));
        for(int i=0;i<5;++i){
            for(int j=0;j<5;++j){
                System.out.print(orchestraLayout(5,i,j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
