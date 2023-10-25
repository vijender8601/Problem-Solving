class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
         Queue<int[]> pq = new PriorityQueue<>((o1,o2)->(o1[2]-o2[2]));
	    int max = -1;
	    for(int i=0;i<nums.size();i++)
	    {
	        pq.add(new int[]{i,0,nums.get(i).get(0)});
	        max = Math.max(max,nums.get(i).get(0));
	    }
	    int diff = (int)1e6,i = -1,j = -1;
	    while(!pq.isEmpty())
	    {
	        int x[] = pq.poll();
	        if(max-x[2]<diff)
	        {
	            diff = max-x[2];
	            i = x[2];
	            j = max;
	        }
	        
	        if(x[1]<nums.get(x[0]).size()-1)
	        {
	            pq.offer(new int[]{x[0],x[1]+1,nums.get(x[0]).get(x[1]+1)});
	            max = Math.max(max,nums.get(x[0]).get(x[1]+1));
	        } else break;
	    }
	    
	    return new int[]{i,j};
    }
}