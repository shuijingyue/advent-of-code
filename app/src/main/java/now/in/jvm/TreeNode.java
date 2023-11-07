package now.in.jvm;

import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        Stack<TreeNode> nodes = new Stack<>();
        StringBuilder builder = new StringBuilder();
        TreeNode node = this;
        while (!nodes.isEmpty() || node != null) {
            while (node != null) {
                builder.append(node.val).append(",");
                nodes.push(node);
                node = node.left;
            }
            node = nodes.pop();
            node = node.right;
        }
        return builder.substring(0, builder.length() - 1);
    }
}
