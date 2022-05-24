class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.add(-1);
        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()) {
                stack.add(c);
                stack1.add(i);
            }
            else {
                if(c == '(') {
                    stack.add(c);
                    stack1.add(i);
                }
                else if(c == ')') {
                    if(stack.peek() == '(') {
                        stack.pop();
                        stack1.pop();
                    }
                    else {
                        stack.add(c);
                        stack1.add(i);
                }
            }
        }
        
}
        int max  = 0;
    if(stack.isEmpty())
        return s.length();
    else {
         int x = s.length()-1;
        while(!stack1.isEmpty()) {
            int ele = stack1.pop();
            max = Math.max(max, x - ele);
            x = ele -1;
        }
    }
        return max;
    }
}