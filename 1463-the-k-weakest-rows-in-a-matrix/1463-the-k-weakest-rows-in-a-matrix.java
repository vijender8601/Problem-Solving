class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length,val[] = new int[n];
        int x = 0;
        int ii[] = new int[n];
        for(int i [] : mat)
        {
            for(int j : i)
            {
                if(j==1) val[x]++;
            }
            ii[x] = x;
            x++;
        }
        
        ii = Arrays.stream(ii).boxed().sorted((i,j)->(val[i]-val[j])).mapToInt($->$).toArray();

        int res[] = new int[k];
        for(int i=0;i<k;i++) res[i] = ii[i];
        return res;
    }
}