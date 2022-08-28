class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals = sorted(intervals,key = lambda interval : interval[0])
        newIntervals = []
        newInterval = intervals[0]
        for idx in range(1,len(intervals)):
            start = intervals[idx][0]
            end = intervals[idx][1]
            newStart = newInterval[0]
            newEnd = newInterval[1]
            if(newEnd < start):
                newIntervals.append(newInterval)
                newInterval = [start,end]
            elif(newStart > end):
                newIntervals.append(intervals[idx])
            else:
                newInterval = [min(start,newStart),max(end,newEnd)]
            
        newIntervals.append(newInterval)
        return newIntervals