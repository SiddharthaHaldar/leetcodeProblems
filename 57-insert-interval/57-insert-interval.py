class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        newIntervals = []
        for idx,interval in enumerate(intervals):
            newStart = newInterval[0]
            newEnd = newInterval[1]
            start = interval[0]
            end = interval[1]
            if(newEnd < start):
                newIntervals.append(newInterval)
                return newIntervals + intervals[idx:]
            elif(newStart > end):
                newIntervals.append(interval)
            else:
                newInterval = [min(start,newStart),max(end,newEnd)]
        
        newIntervals.append(newInterval)
        return newIntervals
                
