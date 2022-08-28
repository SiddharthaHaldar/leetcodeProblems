class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda interval : interval[0])
        keepInterval = intervals[0]
        count = 0
        for idx in range(1,len(intervals)):
            start = intervals[idx][0]
            end = intervals[idx][1]
            keepStart = keepInterval[0]
            keepEnd = keepInterval[1]
            if(keepStart < start and keepEnd <= start):
                keepInterval = intervals[idx]
            else:
                count += 1
                keepInterval = [keepStart,min(end,keepEnd)]
        
        return count