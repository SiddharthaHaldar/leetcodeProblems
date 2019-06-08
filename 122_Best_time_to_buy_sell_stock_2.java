class Solution {
    public int maxProfit(int[] arr) {
        int lptr=0,rptr=1,max=0,diff=0,sum=0,flag=1,l=arr.length,ll=l-1;
        while(rptr<l)
        {
            if(arr[rptr]<arr[rptr-1])
            {
                lptr=rptr;
                sum+=max;
                max=0;
                if(rptr==ll)
                    flag=-1;
            }
            else
            {
                diff=arr[rptr]-arr[lptr];
                if(diff>max)
                    max=diff;
            }
                
        rptr+=1;
        }
        if(flag==1)
            sum+=max;
        return sum;
    }
}