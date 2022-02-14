class Solution {
    static int total_length;
    static int median_length;
    static int length1,length2;
    static int med1 = 0, med2 = 0;
    static int smaller[],larger[];
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        length1 = nums1.length;
        length2 = nums2.length;
        if(length1 > length2) {
            smaller = nums2;
            larger = nums1;
        }
        else {
            smaller = nums1;
            larger = nums2;
        }
        total_length = length1 + length2;
        median_length = total_length/2;
        findMedian(smaller, larger,-1,smaller.length);
        if(med1 == 0)
            return med2;
        else
            return (med1 + med2)/2.0;
    }
    public void findMedian(int smaller[], int larger[],int l,int r) {
        if(l == r) {
            if(l == -1)
                setMedValue(-1,median_length-1);
            else
                setMedValue(l,median_length-smaller.length-1);
            return;
        }
        else {
            int  mid_s = (int)Math.floor((l + r)/2.0);
            int mid_l = median_length-(mid_s+1)-1;
            System.out.println(l+" "+r+" "+mid_s);
            if(getIndex(smaller,mid_s)<=getIndex(larger,mid_l+1)) {
                if(getIndex(smaller,mid_s+1)>=getIndex(larger,mid_l)){
                    setMedValue(mid_s,mid_l);
                    return;
                }
                else
                    findMedian(smaller,larger,mid_s,r);
            }
            else
                findMedian(smaller,larger,l,mid_s);

        }
    }
    public int getIndex(int array[],int ind) {
        if(ind>=array.length)
            return Integer.MAX_VALUE;
        else if(ind<0)
            return Integer.MIN_VALUE;
        return array[ind];
    }
    public void setMedValue(int mid_s,int mid_l) {
        System.out.println(mid_s+" "+mid_l);
        if(total_length % 2==0) {
            med1 = Math.max(getIndex(smaller,mid_s),getIndex(larger,mid_l));
            med2 = Math.min(getIndex(smaller,mid_s+1),getIndex(larger,mid_l+1));
            return;

        }
        else {
            med1 = 0;
            med2 = Math.min(getIndex(smaller,mid_s+1),getIndex(larger,mid_l+1));
            return;
        }
    }
    
}