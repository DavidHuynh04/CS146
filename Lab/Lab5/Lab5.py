class Lab5(object):
    def isValidBST(self, root):
        return self.validBSTHelper(root, float('-inf'), float('inf'))

    def validBSTHelper(self, root, min, max):
        if root is None:
            return True
        if root.val <= min or root.val >= max:
            return False;
        return self.validBSTHelper(root.left, min, root.val) and self.validBSTHelper(root.right, root.val, max)
