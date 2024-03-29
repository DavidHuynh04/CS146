from typing import Optional, List
from queue import Queue
class HW10(object):
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levelList = []
        if root is None:
            return levelList
        queue = Queue()
        queue.put(root)
        while not queue.empty():
            currentLevel = []
            size = queue.qsize()
            for _ in range(size):
                tempNode = queue.get()
                currentLevel.append(tempNode.val)
                if tempNode.left is not None:
                    queue.put(tempNode.left)
                if tempNode.right is not None:
                    queue.put(tempNode.right)
            levelList.append(currentLevel)
        return levelList