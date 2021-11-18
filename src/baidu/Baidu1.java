package baidu;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode1{
    int val;
    TreeNode1 left;
    TreeNode1 right;
}
public class Baidu1 {
    public static List<Integer> mid(TreeNode1 root, List<Integer> ans){
        if(root == null){
            return ans;
        }
        mid(root.left,ans);
        ans.add(root.val);
        mid(root,ans);
        return ans;
    }
    public static boolean jundge(TreeNode1 root){
        List<Integer> list = new ArrayList<>();
        mid(root,list);
        for(int i=1;i<list.size();++i){
            if(list.get(i) <= list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
             
    }
}
