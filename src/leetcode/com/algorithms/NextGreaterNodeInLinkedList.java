package leetcode.com.algorithms;

public class NextGreaterNodeInLinkedList{
    int[] res;

    public int[] nextLargerNodes(ListNode head) {
        calNode(head, 0, new Stack<>());
        return res;
    }

    public void calNode(ListNode node, int index, Stack<Integer> stack) {
        if(node == null) {
            res = new int[index];
            return;
        }
        calNode(node.next, index + 1, stack);
        while(!stack.empty() && stack.peek() <= node.val)
            stack.pop();
        res[index] = stack.empty() ? 0 : stack.peek();
        stack.push(node.val);
    }

    
    public int[] nextLargerNodes2(ListNode head) {
        List<Integer> ansList = new ArrayList<>();
        ListNode cur = head, next = null;
        while(cur!= null){
            int greater = 0;
            next = cur.next;
            while(next!= null){
                if(cur.val<next.val){
                    greater = next.val;
                    break;
                }
                next =next.next;
            }
            ansList.add(greater);
            cur=cur.next;
        }
        int[] ans = new int[ansList.size()];
        int j=0;
        for(int i : ansList){
            ans[j++] = i;
        }
        return ans;
    }
}