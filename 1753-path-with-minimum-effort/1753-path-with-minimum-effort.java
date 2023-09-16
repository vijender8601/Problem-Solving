class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length,m = heights[0].length;
        
        Queue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        int vis[][] = new int[n][m];
        for(int i[] : vis) Arrays.fill(i,(int)1e7);
        q.add(new int[]{0,0,0});

        while(!q.isEmpty())
        {
            int [] temp = q.poll();

            int i = temp[0], j = temp[1], v = temp[2];
            if(vis[i][j]<=v) continue;
            
            vis[i][j] = v;
            if(j+1<m) {
                q.add(new int[]{i,j+1,Math.max(v,abs(heights[i][j]-heights[i][j+1]))});
            }
            if(j-1>=0)
            {
                q.add(new int[]{i,j-1,Math.max(v,abs(heights[i][j]-heights[i][j-1]))});
            }
            if(i+1<n)
            {
                q.add(new int[]{i+1,j,Math.max(v,abs(heights[i][j]-heights[i+1][j]))});
            }
            if(i-1>=0)
            {
                q.add(new int[]{i-1,j,Math.max(v,abs(heights[i][j]-heights[i-1][j]))});
            }
        }

        // for(int i[] : vis)
        // {
        //     for(int j : i)
        //     {
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        // }

        return vis[n-1][m-1];
    }

    int abs(int a)
    {
        return Math.abs(a);
    }
    
}