class Solution {
    int N;
    List<String> l = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        String str = "";
        N = n;
       /*if(n == 0) 
           return new ArrayList<String>();
        else*/
            helper(str,0,0);
        return l;
    }
    public void helper(String str, int open,int closed){
       if(open == closed && open == N){
           l.add(str);
        }
       else{
           if(open + 1 <= N) 
                helper(str + "(" , open + 1, closed);
           if(closed + 1 <= open)
                helper(str + ")" , open , closed + 1);
       }
    }
}