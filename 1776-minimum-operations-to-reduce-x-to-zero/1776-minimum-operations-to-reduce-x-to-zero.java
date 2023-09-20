class Solution {
    public int minOperations(int[] nums, int x) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int sum = 0,n = nums.length;
        for(int i=n-1;i>=0;i--)
        {
            sum+=nums[i];
            map.put(sum,n-i);
        }

        int take = 0,ans = map.getOrDefault(x,n+2);

        for(int i=0;i<n;i++)
        {
            take+=nums[i];
            ans = Math.min(ans,i+1+map.getOrDefault(x-take,n+2));
        }
        
        if(ans>n) return -1;
        return ans;
    }
}