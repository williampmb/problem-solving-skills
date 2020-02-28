package leetcode.com.algorithms;

public class SumofNodeswithEvenValuedGrandparent {

    public static void main(String[] args) {

    }

    public int sumEvenGrandparent(TreeNode root) {
        int result = sumEvenGradparent(root, null, null);
        return result;
    }

    private int sumEvenGradparent(TreeNode node, TreeNode dad, TreeNode granddad) {
        if (node == null)
            return 0;
        int sum = 0;
        if (granddad != null && granddad.val % 2 == 0) {
            sum += node.val;
        }

        sum += sumEvenGradparent(node.left, node, dad);
        sum += sumEvenGradparent(node.right, node, dad);
        return sum;
    }
}