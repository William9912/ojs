package tests;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

class Girl{
    public int face;
    public Girl(){
        face = 0;
    }
    public Girl(int x){
        face = x;
    }
}
class ComGirl implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Girl a = (Girl)o1;
        Girl b = (Girl)o2;
        return a.face - b.face;
    }
}
public class SetTest {
    public static void main(String[] args) {
        SortedSet<Girl> sortedSet = new TreeSet<>(new ComGirl());
        for (int i=100;i>0;i--){
            sortedSet.add(new Girl(i));
        }
        sortedSet.add(new Girl(1));
        for (Girl x : sortedSet){
            System.out.println(x.face);
        }
    }


}
