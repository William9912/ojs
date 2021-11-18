package tests;
import  java.util.*;

public class HuaWei1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //int[] arr = new int[26];
        Map<Character,Integer> map = new HashMap<>();
        while(cin.hasNextLine()){
            String temp = cin.nextLine();
//            if(temp.length()==0){
//                break;
//            }
            String[] arr = temp.split(" ");
//            for(String s:arr){
//                System.out.println(s);
//            }
            String[] arr1 = arr[0].split("-");//qiuduiming
            String[] arr2 = arr[1].split(":");//bifen
            if(Integer.valueOf(arr2[0])>Integer.valueOf(arr2[1])){
                 map.put(arr1[0].charAt(0),map.getOrDefault(arr1[0].charAt(0),0)+3);
                 map.put(arr1[1].charAt(0),map.getOrDefault(arr1[1].charAt(0),0));
            }
            else if(Integer.valueOf(arr2[0])==Integer.valueOf(arr2[1])){
                map.put(arr1[0].charAt(0),map.getOrDefault(arr1[0].charAt(0),0)+1);
                map.put(arr1[1].charAt(0),map.getOrDefault(arr1[1].charAt(0),0)+1);
            }else{
                map.put(arr1[0].charAt(0),map.getOrDefault(arr1[0].charAt(0),0));
                map.put(arr1[1].charAt(0),map.getOrDefault(arr1[1].charAt(0),0)+3);
            }
        }
        List<Map.Entry<Character,Integer> > list = new ArrayList<>();
        for(Map.Entry<Character,Integer> m:map.entrySet()){
            list.add(m);
        }
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if(o1.getValue()==o2.getValue()){
                    return o1.getKey()-o2.getKey();
                }
                return o2.getValue()-o1.getValue();
            }
        });
        for(int i=0;i<list.size();++i){
            System.out.print(list.get(i).getKey());
            System.out.print(" ");
            System.out.print(list.get(i).getValue());
            if(i!=list.size()-1){
                System.out.print(",");
            }

        }
    }
}
