class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int upper_bound[] = new int[n],lower_bound[] = new int[n];
        for(int i=0;i<n;i++)
        {
            lower_bound[i] = flowers[i][0];
            upper_bound[i] = flowers[i][1];
        }

        Arrays.sort(lower_bound); Arrays.sort(upper_bound);

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(lower_bound[i],map.getOrDefault(lower_bound[i],0)+1);
            map.put(upper_bound[i]+1,map.getOrDefault(upper_bound[i]+1,0)-1);
        }

        for(int i : map.keySet())
        {
            Integer key = map.floorKey(i-1);
            if(key!=null) map.put(i,map.get(i)+map.get(key));
        }

        int m = people.length,ans[] = new int[m];
        for(int i=0;i<m;i++)
        {
            Integer key = map.floorKey(people[i]);
            ans[i] = (key==null)?0:map.get(key);
        }

        return ans;
    }
}