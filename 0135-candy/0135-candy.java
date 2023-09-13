class Solution {
    public int candy(int[] ratings) {
        
        int n = ratings.length;

        int res[] = new int[n];
        Arrays.fill(res,1);

        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
              res[i]=res[i-1]+1;
        }
        int ans = res[n-1];
        for(int i=n-2;i>=0;i--)
        {
          if(ratings[i]>ratings[i+1])
          {
            res[i]=Math.max(res[i],(res[i+1]+1));
          }
          ans+=res[i];
        }
        return ans;

    }
}

// 3 2 1 1 0 2 1 0 1 2
// 3 2 1 2 1 3 2 1 2 3
// 3 2 2 1 0 2
// 2 1 3 2 1 2

// 3 2 1 1 0 2 1 0 1 2
// 1 1 1 1 1 1 1 1 1 1
// 1 1 1 1 1 2 1 1 2 3
// 3 2 1 2 1 3 2 1 2 3                 