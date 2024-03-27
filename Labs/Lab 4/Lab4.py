class Lab4(object):
    def invertTree(self, root):
        if root is None:
            return None

        temp = root.left
        root.left = root.right
        root.right = temp

        if root.left is not None:
            self.invertTree(root.left)
        if root.right is not None:
            self.invertTree(root.right)

        return root
