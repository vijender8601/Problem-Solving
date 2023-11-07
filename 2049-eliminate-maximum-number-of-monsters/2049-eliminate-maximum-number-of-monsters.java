class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double time[] = new double[n];
        int ii[] = new int[n];
        for(int i=0;i<n;i++)
        {
            time[i] = (double)dist[i]/(double)speed[i];
            ii[i] = i;
        }

        ii = Arrays.stream(ii).boxed().sorted((i,j)->(time[i]==time[j])?Integer.compare(dist[i],dist[j]):Double.compare(time[i],time[j])).mapToInt($->$).toArray();

        int ans = 1,sec = 1;

        for(int i=1;i<n;i++)
        {
            // System.out.println(time[ii[i]]+" "+dist[ii[i]]);
            int newDist = dist[ii[i]] - speed[ii[i]]*sec;
            if(newDist<=0) break;
            ans+=1;
            sec+=1;
        }

        return ans;
    }
}