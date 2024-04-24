from typing import List

class HW12:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        cost = 0
        cheapest_pipe = [float('inf')] * (n + 1)

        for i in range(n):
            if wells[i] < cheapest_pipe[i + 1]:
                cheapest_pipe[i + 1] = wells[i]

        for pipe in pipes:
            if pipe[2] < cheapest_pipe[pipe[0]]:
                cheapest_pipe[pipe[0]] = pipe[2]
            if pipe[2] < cheapest_pipe[pipe[1]]:
                cheapest_pipe[pipe[1]] = pipe[2]

        visited = []
        for i in range(1, len(cheapest_pipe)):
            if wells[i - 1] <= cheapest_pipe[i]:
                visited.append(i)
                cost += wells[i - 1]

        if not visited:
            lowest = float('inf')
            well = 0
            for i in range(len(wells)):
                if wells[i] < lowest:
                    lowest = wells[i]
                    well = i + 1
            visited.append(well + 1)
            cost += lowest

        pipes.sort(key=lambda x: x[2])

        while len(visited) != n:
            for pipe in pipes:
                house1 = pipe[0] in visited
                house2 = pipe[1] in visited
                if house1 ^ house2:
                    cost += pipe[2]
                    if not house1:
                        visited.append(pipe[0])
                    else:
                        visited.append(pipe[1])
                    break
        return cost