class Solution {
    public int minPartitions(String n) {
      int max = 1; 
      for(int i = 0; i < n.length();i++) {
          int dig = (int)n.charAt(i) - 48;
          max = Math.max(max,dig);
      }
        return max;
    }
}