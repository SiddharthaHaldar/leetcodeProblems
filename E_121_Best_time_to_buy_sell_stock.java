class Solution {
    public int maxProfit(int[] arr) {
    int l=arr.length;
    int lptr=0,rptr=0,max=0,diff=0;
    for(rptr=1;rptr<l;rptr++)
    {
        diff=arr[rptr]-arr[lptr];
        if(arr[rptr]<arr[lptr])
            lptr=rptr;
        /*if(diff<0)
            lptr=rptr;*/
        else if(diff>max)
                max=diff;
    }
    return max;
    }
}