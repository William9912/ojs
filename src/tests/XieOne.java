package tests;
import java.util.*;

public class XieOne {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        Scanner cin = new Scanner(System.in);
        int i1=0;
        while((i1++)<7){
            String temp = cin.nextLine();
            list.add(temp);
        }
        String[] arr = new String[list.size()];
        int index = 0;
        for(String s:list){
            arr[index++] = s;
        }
        Map<String,String[]> map = new HashMap<>();
        for(int i=0;i<arr.length-1;++i){
            String[] temp = arr[i].split(":");
            map.put(temp[1],temp[2].split(","));
        }
        //Set<String[]> set = new TreeSet<>(Comparator.comparingInt(a -> arr[arr.length - 1].indexOf(a[0])));
        List<String[]> list1 = new LinkedList<>();
        for(String key:map.keySet()){
            for(String str:map.get(key)){
                int begin = 0;
                while(arr[arr.length-1].indexOf(str,begin)!=-1){
                    String[] temp = new String[2];
                    temp[0] = str;
                    temp[1] = key;
                    //set.add(temp);
                    list1.add(temp);
                    begin+=str.length();
                }
            }
        }
        Collections.sort(list1,(a,b)->arr[arr.length-1].indexOf(a[0])-arr[arr.length-1].indexOf(b[0]));
        for(String[] t:list1){
            System.out.println(t[0]+":["+t[1]+"]");
        }
    }
}
