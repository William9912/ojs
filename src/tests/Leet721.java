package tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class UnionFind{
    int n;
    int[] size;
    int[] father;
    int countSet;
    public UnionFind(int n){
        this.n = n;
        this.father = new int[n];
        this.size = new int [n];
        for(int i=0;i<n;++i){
            father[i] = i;
        }
        Arrays.fill(size,1);
        countSet = n;
    }
    public int findSet(int x){
        return x==father[x]? x:(father[x] = findSet(father[x]));
    }
    public boolean union(int x,int y){
        x = findSet(x);
        y = findSet(y);
        if(x==y){
            return false;
        }
        if(size[x]<size[y]){
            int temp= x;
            x= y;
            y = temp;
        }
        father[y] = x;
        size[x] += size[y];
        --countSet;
        return true;
    }
}
public class Leet721 {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind fir = new UnionFind(accounts.size());
        List<Integer> ancestors = new LinkedList<>();
        List<List<String>> out = new LinkedList<>();
        for(int i=0;i<accounts.size();++i){
            if(fir.father[i]==i){//ancestor
                ancestors.add(i);
                for(int j=i+1;j<accounts.size();j++){
                    if(accounts.get(i).get(0)==accounts.get(j).get(0)){
                        for(String s:accounts.get(j)){
                            if(accounts.get(i).contains(s)){
                                fir.union(i, j);
                                break;
                            }

                        }
                    }
                }
            }
        }
        for(int i=0;i<accounts.size();++i){
            if(fir.father[i]!=i){
                for(int j=1;j<accounts.get(i).size();++j){
                    if(!accounts.get(fir.father[i]).contains((accounts.get(i).get(j)))){
                        accounts.get(fir.father[i]).add(accounts.get(i).get(j));
                    }
                }
            }
        }
        for(int i:ancestors){
            List<String> temp = new LinkedList<>();
            String name = accounts.get(i).get(0);
            accounts.get(i).remove(0);
            Collections.sort(accounts.get(i));
            temp.add(name);
            for(String s:accounts.get(i)){

                temp.add(s);

            }
            out.add(temp);
        }
        return out;
    }
    public static void main(String[] args) {
        String[][] accounts = {{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}, {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        List<List<String>> accounts2 = new LinkedList<>();
        for(String[] x:accounts){
            List<String> temp = Arrays.asList(x);
            accounts2.add(temp);
        }

        accountsMerge(accounts2);
    }
}
