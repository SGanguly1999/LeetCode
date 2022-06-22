class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> queue = new PriorityQueue();
       for(int i = 0;i<nums.length;i++) {
           queue.add(-nums[i]);
       }
       for(int i = 0; i< k-1;i++)
           queue.poll();
       return -queue.poll();
    }
}