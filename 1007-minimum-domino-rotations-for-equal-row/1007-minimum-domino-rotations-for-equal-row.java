class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int val1 = tops[0];
        int val2 = bottoms[0];
        int count1_no_rot = 0;
        int count1_rot = 0;
        int count1_no_mov = 0;
        int count2_no_rot = 0;
        int count2_rot = 0;
        int count2_no_mov = 0;
        for(int i = 0; i < tops.length; i++) {
            if(val1 == tops[i] && val1 == bottoms[i])
                count1_no_mov++;
            else if(val1 == tops[i])
                count1_no_rot++;
            else if(val1 == bottoms[i])
                count1_rot++;
            if(val2 == tops[i] && val2 == bottoms[i])
                count2_no_mov++;
            else if(val2 == tops[i])
                count2_rot++;
            else if(val2 == bottoms[i])
                count2_no_rot++;
        }
        int no_of_rot1 = -1;
        int no_of_rot2 = -1;
        if(count1_no_rot + count1_rot + count1_no_mov >= tops.length)
            no_of_rot1 = Math.min(count1_no_rot,count1_rot);
        if(count2_no_rot + count2_rot +count2_no_mov>= tops.length)
            no_of_rot2 = Math.min(count2_no_rot,count2_rot);
       System.out.println(count2_no_rot+" "+count2_rot);
        if(no_of_rot1 >=0 && no_of_rot2 >=0)
            return Math.min(no_of_rot1,no_of_rot2);
        else
            return Math.max(no_of_rot1,no_of_rot2);
    
    }
}