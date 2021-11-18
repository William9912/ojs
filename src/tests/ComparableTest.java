package tests;

import java.util.*;

class Point implements Comparable{
    public int x;
    public int y;
    static int r0;
    static int c0;
    public int dis;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.dis = Math.abs(this.x - Point.r0) + Math.abs(this.y - Point.c0);
    }
    public void print(){

        System.out.println(this.x);
        System.out.println(this.y);
        System.out.println(this.dis);
        System.out.println();
    }
    @Override
    public int compareTo(Object o) {
        Point p = (Point)o;
        return this.dis - p.dis;
    }
}
class ComOfPoint implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Point a = (Point)o1;
        Point b = (Point)o2;
        return a.dis - b.dis;
    }
}

public class ComparableTest {
    public static void main(String[] args) {
        Point.r0 = 0;
        Point.c0 = 1;

        Point[] arr = new Point[4];
        for(int i = 0;i<2 ;i++){
            for(int j=0;j<2;j++){
                arr[i*2 + j] = new Point(i,j);
            }
        }

//        Arrays.sort(arr, new ComOfPoint());
//        for (Point p:arr){
//            p.print();
//        }
        List<Point> list = new LinkedList<>();
        for(int i = 0;i<2 ;i++){
            for(int j=0;j<2;j++){
                list.add(new Point(i, j));
            }
        }
        Collections.sort(list,new ComOfPoint());
        for(Point x:list){
            x.print();
        }
    }
}
