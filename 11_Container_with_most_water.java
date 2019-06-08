class Solution {
    public int maxArea(int[] height) {
        int l=height.length,area=0,max=0,lptr=0,rptr=l-1;
        for(int x=0;x<l;x++)
        {
            area=(rptr-lptr)*Math.min(height[lptr],height[rptr]);
            max=Math.max(area,max);
            if(height[lptr]>height[rptr])
                rptr-=1;
            else
                lptr+=1;
        }
        return max;
    }
}