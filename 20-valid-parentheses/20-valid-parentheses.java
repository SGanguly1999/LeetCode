class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack<Integer>();
        for(int i=0; i<s.length(); i++) {
           char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                stack.add(encode(c));
            else {
                if(!stack.isEmpty()) {
                int i1 = (int)stack.pop();
                int i2 = encode(c);
                if(i1 != i2)
                    return false;
                }
                else
                    return false;
                    
            }
        }
        if(stack.isEmpty())
          return true;
        else
            return false;
    }
    public int encode(char c) {
        if(c == '(' || c == ')')
            return 1;
        else if(c == '{' || c == '}')
            return 2;
        else if(c == '[' || c == ']')
            return 3;
        return 3;
    }
}