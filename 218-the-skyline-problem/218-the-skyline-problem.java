class Point implements Comparable<Point> {
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", inc=" + inc + "]";
	}
	int x;
	int y;
	int inc;
	Point(int x1,int y1,int inc1) {
		x=x1;
		y=y1;
		inc=inc1;
	}
	@Override
	public int compareTo(Point o) {
	 if(this.x==o.x)
	 return o.inc-this.inc;
	 else
	 return this.x-o.x;
	}
}

class Solution {
	 public List<List<Integer>> getSkyline(int[][] buildings) {
	        int len=buildings.length;
			System.out.println(buildings.length);
	        ArrayList<Point> mp=new ArrayList<Point>();
	        for(int i=0;i<len;i++) {
	            int left=buildings[i][0]; // starting of the building
	            int right=buildings[i][1]; // ending of the building
	            int height=buildings[i][2]; // height of the building
	            Point x=new Point(left,height,0); // starting coordinate of the building
	            Point y=new Point(right,height,1); // End coordinate of the building
	            mp.add(x); // adding the starting coordinate to the point list
	            mp.add(y); // adding the ending coordinate to the point list
	        }
	        Collections.sort(mp);
	        List<List<Integer>> list=new ArrayList();
	        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(new Comparator<Integer>() {
	        	 public int compare(Integer a, Integer b)
                 {
                     if (a < b)
                         return 1;
                     if (a > b)
                         return -1;
                     return 0;
                 }
	        });
            //int prev_val=100000000;
	        for(Point x:mp) {
	            ArrayList<Integer> cor=new ArrayList<Integer>();
	           //System.out.println(x);
	            if(x.inc==0) {
	                int val=0;
	                if(queue.peek()!=null)
	            	 val=queue.peek();
	            	queue.add(x.y);
	            	//System.out.println(queue.peek()+" "+val);
	       	        if(val!=queue.peek()) {
	       	        	cor.add(x.x);
	       	        	cor.add(queue.peek());
	                    //System.out.println(x.x+" "+queue.peek());
	       	        }
	            }
	            else {
	            	int val=queue.peek();
	            	queue.remove(x.y);
	            	if(queue.peek()==null) {
	            		cor.add(x.x);
	            		cor.add(0);
	            		//System.out.println(x.x+" "+0);
	            	}
	            		
	            	else if(val!=queue.peek()) {
	       	        	cor.add(x.x);
	       	        	cor.add(queue.peek());
	       	        	//System.out.println(x.x+" "+queue.peek());
	            }
	            
	        }
	            if(!cor.isEmpty()) {
                    if(list.size()!=0) {
	            	var p_cor=list.get(list.size()-1);
	            	if((int)p_cor.get(0)==(int)cor.get(0)) {
					//System.out.println(p_cor.get(0)+" "+cor.get(0));
	            	if(x.inc==0) {
	            		ArrayList<Integer> cor1=new ArrayList<Integer>();
	            		cor1.add(cor.get(0));
	            		cor1.add(Math.max(p_cor.get(1),cor.get(1)));
						System.out.println("Removed "+list.get(list.size()-1));
                        list.remove(list.size()-1);
						System.out.println("Added "+cor1);
	            		list.add(cor1);
                        cor=cor1;
	            	}
	            	else {
	            		ArrayList<Integer> cor1=new ArrayList<Integer>();
	            		cor1.add(cor.get(0));
	            		cor1.add(Math.min(p_cor.get(1),cor.get(1)));
						System.out.println("Removed "+list.get(list.size()-1));
                        list.remove(list.size()-1);
						System.out.println("Added "+cor1);
	                    list.add(cor1);
                        cor=cor1;
                    
	            	}
	            	}
                        else 
                           list.add((List<Integer>)cor);
                    }
	            	else
	                list.add((List<Integer>)cor);
                    if(list.size()>1) {
                     if(cor.get(1)==list.get(list.size()-2).get(1))
                    list.remove(list.size()-1);
                    }
                    
                    }
               
	            
	    }
	return list;
	    }
	}
