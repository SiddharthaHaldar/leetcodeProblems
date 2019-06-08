class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int l=s.length();
        int ci=0,cd=numRows-1,count=1,flag=-1;
        int next=ci;
        char arr[]=new char[l];
        for(int x=0;x<l;x++)
        {
            arr[x]=s.charAt(next);
            flag*=-1;
            if(ci==0 && cd ==numRows-1)
                next=next+2*cd;
            else if(ci==numRows-1 && cd==0)
                next=next+2*ci;
            else if(flag==1)
                next=next+2*cd;
            else if(flag==-1)
                next=next+2*ci;
            if(next>l-1)
            {
                ci+=1;
                cd-=1;
                flag=-1;
                next=ci;
            }
            //System.out.println(next);
        }
        return new String(arr);
    }
}