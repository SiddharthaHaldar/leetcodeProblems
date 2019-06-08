class Solution {
    public String longestPalindrome(String s) {
        int l=s.length();
        int a[][]=new int[l][l];
        int c=0,x=0,ll=0,xpos=0,ypos=0;
        for(int y=c;y<l;y++)
        {//System.out.println(y);
            if(x==y)
            {
                a[x][y]=1;
                ll=1;
                xpos=x;
                ypos=y;
            }
            else
            {   
                if(s.charAt(x)==s.charAt(y))
                {   //System.out.println(x+" "+y);
                    if(a[x+1][y-1]==1)
                        {a[x][y]=1;
                        ll=y-x+1;
                        xpos=x;}
                    else if(x+1==y)
                        {a[x][y]=1;
                        ll=y-x+1;
                        xpos=x;}
                }            
            }
            x+=1;
            if(y==l-1)
            {
                x=0;
                y=c;
                //System.out.println(y);
                c+=1;
            }
        }
    
    return s.substring(xpos,xpos+ll);
    }
}