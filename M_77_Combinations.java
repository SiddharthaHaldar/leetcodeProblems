class Solution {
    int k=0,n=0;
    List<List<Integer>> ll=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        this.k=k;
        this.n=n;
        func(1,new ArrayList<Integer>());
        return ll;
    }
    public void func(int i,List<Integer> list)
    {
        if(i==n)
        {}
        if(list.size()==k){
            ll.add(new ArrayList<>(list));
            return;
        }
        int spaceLeft = k - list.size();
        /*System.out.println(list);
        System.out.println(spaceLeft);*/
        for(int x=i;x<=n && spaceLeft<=n-x+1;x++)
        {
            list.add(x);
            //System.out.println("inside loop:"+list);
            func(x+1,list);
            list.remove(list.size()-1);
        }
    }
}