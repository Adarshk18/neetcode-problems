class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()

        res = []

        current = intervals[0]
        for i in range(len(intervals)):
            if current[1] >= intervals[i][0]:
                current[1] = max(current[1],intervals[i][1])
            else:
                res.append(current)
                current = intervals[i]

        res.append(current)
        return res            
        