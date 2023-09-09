class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        int n = nums.length;
        Arrays.sort(nums);
        dp[0] = 1;
        for(int i=1;i<=target;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(nums[j]>i) continue;

                dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}