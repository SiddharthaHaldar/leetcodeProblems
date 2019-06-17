class Solution {
    List<List<Integer>> ll=new ArrayList<>();
    int nums2[];
    public List<List<Integer>> subsets(int[] nums) {
        nums2=nums;
        func(0,new ArrayList<Integer>());
        return ll;
    }
    public void func(int i,List<Integer> list)
    {
        if(i==nums2.length)
        {}
        ll.add(new ArrayList<>(list));
        for(int x=i;x<nums2.length;x++)
        {
            list.add(nums2[x]);
            func(x+1,list);
            list.remove(list.size()-1);
        }
    }
}