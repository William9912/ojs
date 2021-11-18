package tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

class Node{
    int x;
    Node next;
    Node(int x,Node next){
        this.x =x;
        this.next = next;
    }
    Node(){
        x= 0;
        next = null;
    }
}
public class ChainSort {
    public static void insertSort(Node head){
        if(head == null){
            return;
        }
        Node past = head.next;
        head.next = null;
        while(past!=null){
            if(past.x<head.x){
                Node temp = past.next;
                past.next = head;
                head = past;
                past = temp;
                continue;
            }
            Node p = head;
            while(p!=null){
                if(p.next == null||(past.x>=p.x&&past.x<=p.next.x)){
                    Node temp = p.next;
                    p.next = past;
                    past = past.next;
                    p.next.next = temp;
                    break;
                }
                p=p.next;
            }
        }
    }
    public static Node[] chainToArr(Node head){
        Node [] arr = new Node[10000000];
        int i=0;
        while(head!=null){
            arr[i++] = head;
            head = head.next;
        }
        return arr;
    }
    public static void quickSort(Node [] arr,int l,int r){
        if(l+1>=r){
            return ;
        }
        int first = l,last = r -1;
        Node key = arr[first];
        while(first<last){
            while (first<last&& arr[last].x>=key.x){
                --last;
            }
            arr[first] = arr[last];
            while(first<last&&arr[first].x<=key.x){
                ++first;
            }
            arr[last] = arr[first];
        }
        arr[last] = key;
        quickSort(arr,l,last);
        quickSort(arr,last+1,r);
    }
    public static void mergeSort(Node[] arr, int l ,int r) {
        if(l+1>=r) {
            return ;
        }
        int m = l+(r-l)/2;
        mergeSort(arr, l, m);
        mergeSort(arr,m,r);//这里merge和quick不一样是因为merge下标为m的的数并没有在自己的位置，而quick已经在自己的最终位置了
        Vector<Node> temp = new Vector<>();
        int i = l,j = m;
        while(i<m||j<r) {
            if(j>=r||(i<m&&arr[i].x<=arr[j].x)) {//等于编程稳定排序，i在左面，还是i先放进去，不让就是不稳定了
                temp.add(arr[i++]);
            }
            else {
                temp.add(arr[j++]);
            }
        }
        int k = l;
        for(Node x:temp) {
            arr[k++] = x;
        }
    }
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();    //获取开始时间
        Node head = new Node(7, null);
        Node p = head;
        for (int i = 1; i < 10000000; ++i) {
            int val = (int) (Math.random() * 10000);
            //System.out.println(val);
            Node temp = new Node(val, null);
            p.next = temp;
            p = temp;
        }
        //insertSort(head);
        Node[] arr = chainToArr(head);
        //quickSort(arr, 0, arr.length);
        quickSort(arr, 0, arr.length);
        System.out.println(arr.length);
        BufferedWriter out = new BufferedWriter(new FileWriter("runoob.txt"));
        for (Node n : arr) {
            String str = "" + n.x;
            out.write(str);
            out.write('\n');
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        out.write("算法所用时间（毫秒）");//千万级数据归并排序和快速排序大约都为10秒
        out.write(""+(endTime-startTime));//1亿数据归并排序是174秒
        out.close();


    }
}
