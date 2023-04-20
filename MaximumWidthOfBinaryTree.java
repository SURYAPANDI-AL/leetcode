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
 class Entry{
     int index;
     TreeNode node;
     int level;
     public Entry(int index, TreeNode node, int level){
         this.index = index;
         this.node = node;
         this.level = level;
     }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Entry> queue = new LinkedList<>();
        queue.add(new Entry(0,root,1));
        int max = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int first = 0, last = 0;
            for(int i=0;i<size;i++){
                if(i==0) first = queue.peek().index;
                if(i==size-1) last = queue.peek().index;
                Entry entry = queue.poll();
                TreeNode curNode = entry.node;
                if(curNode.left != null){
                    queue.add(new Entry(entry.index*2+1,curNode.left,entry.level+1));
                }
                if(curNode.right != null ){
                    queue.add(new Entry(entry.index*2+2,curNode.right,entry.level+1));
                }  
            }
            max = Math.max(max,last-first+1);
        }
        return max;
    }
}
