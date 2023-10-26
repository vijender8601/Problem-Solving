class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long ans = 0,mod = (long)1e9+7;
        Map<Integer,Long> map = new HashMap<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            long val = 1;
            for(int j=0;j<i;j++)
            {
                if(arr[i]%arr[j]==0)
                {
                    val+=(map.get(arr[j])*map.getOrDefault(arr[i]/arr[j],0l));
                }
            }
            map.put(arr[i],val);
            ans+=val;
            ans%=mod;
        }

        // pl(ans);
        return (int)ans;
    }
}