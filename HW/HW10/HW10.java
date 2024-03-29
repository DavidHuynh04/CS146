import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class HW10 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) {
            return levelList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            TreeNode tempNode;
            for (int i = 0; i < size; i++) {
                tempNode = queue.poll();
                currentLevel.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            levelList.add(currentLevel);
        }
        return levelList;
    }
}
