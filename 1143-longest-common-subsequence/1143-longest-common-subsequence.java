class Solution {
    static int mp[][];
    public int longestCommonSubsequence(String text1, String text2) {
         mp=new int[text1.length()][text2.length()];
       for(int i=0;i<text1.length();i++) {
    	   for (int j=0;j<text2.length();j++) {
    		   mp[i][j]=-1;
    	   }
       }
        int result=longestsubsequence(text1,text2,0,0);
       // System.out.println(result);
        return mp[0][0];
        
    }
    
    public static int longestsubsequence(String text1, String text2, int i, int j) {
		 if(text1.length()==0 || text2.length()==0)
            return 0;
        char c1=text1.charAt(0);
		char c2=text2.charAt(0);
		String sub_text1=text1.substring(1,text1.length());
		String sub_text2=text2.substring(1,text2.length());
       
		if(c1 == c2) {
			if(mp[i][j]==-1) {

	        mp[i][j]=Math.max(mp[i][j], 1+longestsubsequence(sub_text1,sub_text2,i+1,j+1));
                //System.out.println(text1+" "+text2+" "+i+" "+j+" "+" "+mp[i][j]);
			}
	        return mp[i][j];
	}
		else {
			if(mp[i][j]==-1) {
				mp[i][j]=Math.max(mp[i][j],Math.max(longestsubsequence(sub_text1,text2,i+1,j),longestsubsequence(text1,sub_text2,i,j+1)));
		   		//System.out.println(text1+" "+text2+" "+i+" "+j+" "+" "+mp[i][j]);		
            }
			return mp[i][j];
		}
			
		}
}