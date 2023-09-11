class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = groupSizes.length;
        int vis[] = new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==1) continue;
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                if(vis[j]==1 || groupSizes[i]!=groupSizes[j]) continue;
                temp.add(j);
                vis[j]=1;
                if(temp.size()==groupSizes[i])
                {
                    break;
                }
            }
            if(temp.size()>0) ans.add(temp);
        }

        return ans;
    }
}