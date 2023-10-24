/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>(),temp = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int x = Integer.MIN_VALUE;
            while(!q.isEmpty())
            {
                TreeNode node = q.poll();
                x = Math.max(x,node.val);

                if(node.left!=null) temp.add(node.left);
                if(node.right!=null) temp.add(node.right);
            }
            q.addAll(temp);
            temp.clear();
            ans.add(x);
        }

        return ans;
    }
}