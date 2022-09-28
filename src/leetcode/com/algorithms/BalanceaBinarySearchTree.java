package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class BalanceaBinarySearchTree {

    public static void main(String[] args){

        TreeNode a = new TreeNode(1);
        TreeNode ar = new TreeNode(2);
        TreeNode arr = new TreeNode(3);
        TreeNode arrr = new TreeNode(4);
        a.right = ar;
        ar.right = arr;
        arr.right = arrr;


        BalanceaBinarySearchTree b= new BalanceaBinarySearchTree();
        b.balanceBST(a);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        return generateBigGreaterTree(list, 0, list.size() - 1);
    }

    public void preOrder(TreeNode cur, List<TreeNode> list) {
        if (cur == null)
            return;

        preOrder(cur.left, list);
        list.add(cur);
        preOrder(cur.right, list);
    }

    public TreeNode generateBigGreaterTree(List<TreeNode> list, int start, int end) {
        if (start > end)
            return null;

        int mid = (end - start) / 2 + start;
        TreeNode midNode = list.get(mid);
        TreeNode cur = new TreeNode(midNode.val);
        cur.left = generateBigGreaterTree(list, start, mid-1);
        cur.right = generateBigGreaterTree(list, mid+1, end);

        return cur;
    }
}
