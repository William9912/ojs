//package wangyihuyu;
//
//import java.util.*;
//public class Sec {
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int T  = cin.nextInt();
//        for(int i=0;i<T;++i){
//            int N = cin.nextInt();
//            List<List<Integer>> gragh = new ArrayList<>(N);
//            for(int j=0;j<N;++j){
//                gragh.add(new ArrayList<>());
//            }
//            int[] cost = new int[N];
//            int[] degree = new int[N];
//            for(int j = 0;j<N;++j){
//                int Di = cin.nextInt();
//                cost[j] = Di;
//
//                int Ki = cin.nextInt();
//                degree[j] =Ki;
//                for(int k = 0;k<Ki;++k){
//                    int pre = cin.nextInt();
//                    gragh.get(pre - 1).add(j);
//                }
//                }
//            }
//            int resolved = 0;
//            int time = 0;
//            int N = 2;
//            boolean[] vised = new boolean[N];
//            while(resolved < N){
//                List<Integer> list = new ArrayList<>();
//                for(int j=0;j<N;++j){
//                    if(!vised[j]&&degree[j] == 0){
//                        list.add(j);
//                    }
//                }
//                int minCost = Integer.MAX_VALUE;
//                for(int j:list){
//                    if(cost[j] < minCost){
//                        minCost = cost[j];
//                    }
//                }
//                //System.out.println(minCost);
//                time += minCost;
//                for(int j:list){
//                    cost[j] -= minCost;
//                    if(cost[j]== 0){
//                        vised[j] = true;
//                        resolved ++;
//                        for(int k:gragh.get(j)){
//                            degree[k] --;
//                        }
//                    }
//                }
//            }
//            System.out.println(time);
//        }
//    }
//}
