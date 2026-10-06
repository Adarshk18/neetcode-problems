class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        prev = [0] * (amount+1)

        for i in range(amount+1):
            if i%coins[0] == 0:
                prev[i] = 1


        for ind in range(1,n):
            curr = [0] * (amount+1)
            for target in range(amount+1):
                notTake = prev[target]
                take = 0
                if coins[ind]<=target:
                    take = curr[target-coins[ind]]

                curr[target] = take + notTake    

            prev = curr
        return prev[amount]            


        