class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if(len(intervals) == 0 or newInterval[0] > intervals[-1][1]):
            intervals.append(newInterval)
            return intervals
        newIntervals = []
        copyIdx = 0
        for idx,interval in enumerate(intervals):
            start = interval[0]
            end = interval[1]
            newStart = newInterval[0]
            newEnd = newInterval[1]
            if(newStart <= start):
                copyIdx = self.findEnd(idx,start,end,newStart,newEnd,intervals,newIntervals)
                break
            if(newStart <= end):
                newStart = start 
                copyIdx = self.findEnd(idx,start,end,newStart,newEnd,intervals,newIntervals)
                break
            if(newStart > end):
                newIntervals.append(interval)
        
        for idx in range(copyIdx,len(intervals)):
            newIntervals.append(intervals[idx])
        
        return newIntervals
    
    def findEnd(self,idx,start,end,newStart,newEnd,intervals,newIntervals):
        copyIdx = 0
        if(newEnd < start):
            newIntervals.append([newStart,newEnd])
            copyIdx = idx
        elif(newEnd == start):
            newIntervals.append([newStart,end])
            copyIdx = idx + 1
        elif(newEnd <= end):
            newIntervals.append([newStart,end])
            copyIdx = idx + 1
        elif(newEnd > end):
            if(idx == len(intervals) - 1):
                newIntervals.append([newStart,newEnd])
                copyIdx = idx + 1
            else:
                idx += 1
                while(idx <= len(intervals) - 1):
                    if(newEnd < intervals[idx][0]):
                        newIntervals.append([newStart,newEnd])
                        copyIdx = idx
                        break
                    if(newEnd == intervals[idx][0] or newEnd <= intervals[idx][1]):
                        newIntervals.append([newStart,intervals[idx][1]])
                        copyIdx = idx + 1
                        break
                    if(newEnd > intervals[idx][1]):
                        if(idx == len(intervals) - 1):
                            newIntervals.append([newStart,newEnd])
                            copyIdx = idx + 1
                            break
                        idx += 1
                        continue
        return copyIdx
                
        