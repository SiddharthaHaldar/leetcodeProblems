class Solution {
    public int totalFruit(int[] tree) {
        int l=tree.length,num1=-1,num2=-1,start=0,num1end=0,num2end=0,end,max=-1;
        for(end=0;end<l;end++)
        {
            if(tree[end]==num1)
                num1end=end;
            else if(tree[end]==num2)
                num2end=end;
            else
            {
                if(num1==-1)
                {
                    num1=tree[end];
                    num1end=end;
                }
                else if(num2==-1)
                {
                    num2=tree[end];
                    num2end=end;
                }
                else
                {
                    max=max>(end-start)?max:(end-start);
                    if(tree[end-1]==num2)
                    {
                        num1=tree[end];
                        start=num1end+1;
                        num1end=end;
                    }
                    else if(tree[end-1]==num1)
                    {
                        num2=tree[end];
                        start=num2end+1;
                        num2end=end;
                    }
                }
            }
        }
        max=max>(end-start)?max:(end-start);
        return max;
    }
}