class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int l = temperatures.length;
        int answer[] = new int[l];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for(int x = 1; x < l ; x++){
            while(!stack.empty() && temperatures[x] > temperatures[stack.peek()]){
                answer[stack.peek()] = x - stack.peek();
                stack.pop();
            }
            stack.push(x);
            //System.out.println(stack);
        }
        return answer;
    }
}