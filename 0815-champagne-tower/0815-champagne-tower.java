class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] curr = new double[1];
        curr[0] = poured;

        for(int i=0;i<=query_row;i++)
        {
            double [] temp = new double[i+2];
            for(int j=0;j<=i;j++)
            {
                if(curr[j]<1.0)
                {
                    continue;
                }
                temp[j] += (curr[j]-1)/2;
                temp[j+1] += (curr[j]-1)/2;
                curr[j] = 1;
            }
            if(i!=query_row) curr = temp;
        }

        return curr[query_glass];
    }
}