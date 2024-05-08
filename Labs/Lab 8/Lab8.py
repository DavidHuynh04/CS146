class Lab8(object):
    def coinChange(self, coins: List[int], amount: int) -> int:
        dpArray = [float('inf')] * (amount + 1)
        dpArray[0] = 0
        for i in range(len(coins)):
            for j in range(coins[i], amount + 1):
                if dpArray[j - coins[i] != float('inf')]:
                    if dpArray[j - coins[i]] < dpArray[j]:
                        dpArray[j] = dpArray[j - coins[i]] + 1
        if dpArray[amount] == float('inf'):
            return -1
        else:
            return dpArray[amount]


