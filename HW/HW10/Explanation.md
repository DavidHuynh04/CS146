The purpose of this code is to return the level order traversal of a binary tree in the form of a list of lists that contain the values of the nodes on each level of the tree.
Theory behind the code: The main task at hand is keeping track of which nodes belong to which level. The way my code keeps track of this is using a queue linked list and a while loop. In order to accomplish the task of separating each level of the binary tree, at the start of the while loop, the queue should contain all of the nodes in the current level of the binary tree, and at the end of the while loop, the queue should only contain the children of those nodes, meaning all of the nodes of the next level, which can allow us to return to the start of the while loop and work through the nodes of that current level, until we have traversed through all of the levels (the queue is empty becase there are no more nodes to add). This can function as the first level, has only the root node, so we can start the while loop with all of the nodes of the first level by adding the root. During the start of each loop, we will make a reference of how many nodes are in the queue, meaning how many nodes are on that level. We will have a for loop, which for each node of that current level (counted by the reference size), we can remove it from the queue and then both add the value of that node to a list, and add the left and right children to the queue. Through this process, we make a list of all of the values of the nodes of the current level, while making sure that the queue is prepared for the next for loop with all of the children nodes, AKA the nodes of the next level. We can then add the list of the current level node values, to the level list, which contains  the lists of each level. By the end of this, we will have traversed through every level, and produced a list that contains the lists of all the values of the nodes for each level. One more thing to note is that the way we keep the nodes in order is that we add the left child node first, and then the right child node next. Additionally, we use the queue data structure which is first in first out, so we can maintain the order.