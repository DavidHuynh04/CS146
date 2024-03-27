public class Lab5 {
    public boolean isValidBST(TreeNode root) {
        return validBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean validBSTHelper(TreeNode root, Integer min, Integer max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        return validBSTHelper(root.left, min, root.val) && validBSTHelper(root.right, root.val, max);
    }
}
