class Solution {
    public int evalRPN(String[] tokens) {
        int l = tokens.length;
        Stack<Integer> stack = new Stack<Integer>();
        for(int x = 0; x < l; x++){
            if(!tokens[x].equals("+") &&
               !tokens[x].equals("-") &&
               !tokens[x].equals("*") &&
               !tokens[x].equals("/")){
                stack.push(Integer.parseInt(tokens[x]));
            }
            else{
               int num1 = stack.pop();
               int num2 = stack.pop();
               if(tokens[x].equals("+"))
                   stack.push(num1 + num2);
               if(tokens[x].equals("-"))
                   stack.push(num2 - num1);
               if(tokens[x].equals("*"))
                   stack.push(num1 * num2);
               if(tokens[x].equals("/"))
                   stack.push(num2 / num1);
            }
            //System.out.println(stack.peek());
        }
        return stack.pop();
    }
}