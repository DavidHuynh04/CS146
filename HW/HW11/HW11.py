from collections import deque
class HW11(object):
    def floodFill(self, image, sr, sc, color):
        current = image[sr][sc]
        visited = []
        queue = deque()
        temp = [sr,sc]
        queue.append(temp)
        while queue:
            temp = queue.pop()
            sr = temp[0]
            sc = temp[1]
            if sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] != current:
                continue
            image[sr][sc] = color
            visited.append(temp)
            temp = [sr+1,sc]
            if temp not in visited:
                queue.append(temp)
            temp = [sr-1,sc]
            if temp not in visited:
                queue.append(temp)
            temp = [sr,sc+1]
            if temp not in visited:
                queue.append(temp)
            temp = [sr,sc-1]
            if temp not in visited:
                queue.append(temp)
        return image