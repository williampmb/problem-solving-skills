package leetcode.com.algorithms;

public class BinarySearchTreetoGreaterSumTree {
    
    public TreeNode bstToGst(TreeNode root) {
        TreeNode acc = new TreeNode(0);
        bstToGst(root,acc);
        return root;
    }

    TreeNode bstToGst(TreeNode root, TreeNode acc){
        if(root == null){
            return null;
        }

        TreeNode sum = bstToGst(root.right, acc);
        if(sum != null){
            root.val += sum.val;
            acc.val =  root.val;
        }else if(acc != null){
            root.val += acc.val;
            acc.val = root.val;
        }

        TreeNode sumleft = bstToGst(root.left, acc);

        return sumleft != null ? sumleft : root;

    }
}

//[3,2,4,1]
//[7,9,4,1]


//3



//[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]