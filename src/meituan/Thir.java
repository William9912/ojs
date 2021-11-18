package meituan;
import java.util.*;
class Node{
    int index;
    boolean dir ;
    int pos;
}
public class Thir {
    public static int[] find(Stack<Node> stack, Deque<Node> deque){
        Node left = deque.getFirst();
        deque.poll();
        int[] out = new int[3];
        Arrays.fill(out,Integer.MIN_VALUE);
        if(left.dir){
            stack.push(left);
            return out;
        }
        if(stack.isEmpty()){
            out[0] = left.pos;
            out[1] = -1;
            return out;
        }else if((stack.peek().index - left.index)%2==0){
            out[0] = left.pos;
            out[1] = (left.index-stack.peek().index  )/2;
            out[2] = stack.peek().pos;
            stack.pop();
            return out;
        }
        Node top = stack.pop();
        deque.addFirst(top);
        deque.addFirst(left);
        return find(stack,deque);
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin .nextInt();

        List<Node> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        for(int i=0;i<n;++i){
            Node node = new Node();
            String temp = cin.nextLine();
            if(temp.length()==0){
                i--;
                continue;
            }
            String[] arr = temp.split(" ");

            int index = Integer.valueOf(arr[0]);
            if(arr[1].equals("L")){
                node.dir = false;
            }else{
                node.dir = true;
            }
            node.index = index;
            node.pos = i;
            list.add(node);
        }
        Collections.sort(list,(a ,b)->{
            return a.index - b.index;
        });
        Deque<Node> deque = new LinkedList<>(list);
        int[] end = new int[n];
        while(!deque.isEmpty()){
            int[] ans = find(stack,deque);
            if(ans[2]!=Integer.MIN_VALUE){
                end[ans[2]] = ans[1];
                end[ans[0]] = ans[1];
            }else if(ans[0] != Integer.MIN_VALUE){
                end[ans[0]] = ans[1];
            }
        }
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            end[temp.pos] = -1;
        }
        for(int x:end){
            System.out.println(x);
        }
    }
}
