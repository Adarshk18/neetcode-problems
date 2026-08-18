class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[0])

        prevEnd = intervals[0][1]
        cnt =0
        for i in range(1, len(intervals)):
            if prevEnd <= intervals[i][0]:
                prevEnd = intervals[i][1]
            else:
                cnt+=1
                prevEnd = min(prevEnd,intervals[i][1])

        return cnt            
        