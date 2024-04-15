from collections import deque
class Lab6(object):
    def canFinish(numCourses, prerequisites):
        adjacencyCount = [0] * numCourses
        for prerequisitePair in prerequisites:
            needsPrerequisite = prerequisitePair[0]
            adjacencyCount[needsPrerequisite] += 1
        queue = deque()
        for i in range(len(adjacencyCount)):
            if adjacencyCount[i] == 0:
                queue.append(i)
        visited = []
        while queue:
            temp = queue.pop()
            for prerequisitePair in prerequisites:
                if prerequisitePair[1] == temp:
                    adjacencyCount[prerequisitePair[0]] -= 1
                    if adjacencyCount[prerequisitePair[0]] == 0:
                        queue.append(prerequisitePair[0])
            visited.append(temp)
        return len(visited) == numCourses