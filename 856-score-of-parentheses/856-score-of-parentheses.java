class Solution {
    public int scoreOfParentheses(String s) {
        Stack stack = new Stack<Character>();
        Stack res = new Stack<Integer>();
        s = "("+s;
        int length = s.length();
        for(int i=0;i<length;i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.add('(');
                res.add(0);
            }
            else if(c == ')') {
                stack.pop();
                int result = (int)res.pop();
                if(result == 0)
                    result = 1;
                if(!stack.isEmpty()) {
                    int val = (int)res.pop();
                    val = val/2 + result;
                    res.add(2*val);
                }
            }
        }
        return (int)res.pop()/2;
    }
}