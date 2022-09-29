package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class AllElementsinTwoBinarySearchTrees {
 
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> tree1 = new ArrayList<>();
        preeOrder(root1, tree1);
        List<Integer> tree2 = new ArrayList<>();
        preeOrder(root2, tree2);

        int l = 0;
        int r = 0;

        List<Integer> ans = new ArrayList<>();
        while(l < tree1.size() && r < tree2.size() ){
            int val = tree1.get(l);
            int val2 = tree2.get(r);
            if(val<val2){
                ans.add(val);
                l++;
            }else if(val>val2){
                ans.add(val2);
                r++;
            }else{
                ans.add(val);
                ans.add(val2);
                l++;
                r++;
            }
        }

        addRemaining(tree1,l,ans);
        addRemaining(tree2,r,ans);
        return ans;
        
    }

    public void preeOrder(TreeNode n1, List<Integer> numbs){
        if(n1 == null) return;

        preeOrder(n1.left, numbs);
        numbs.add(n1.val);
        preeOrder(n1.right, numbs);
    }

    public void addRemaining(List<Integer> node, int pointer, List<Integer> list){
        while(pointer<node.size()){
            list.add(node.get(pointer++));
        }
    }
}


