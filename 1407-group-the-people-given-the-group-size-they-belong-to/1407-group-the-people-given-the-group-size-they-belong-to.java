class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = groupSizes.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(groupSizes[i]) || map.get(groupSizes[i]).size()==0) map.put(groupSizes[i],new ArrayList<>());
            map.get(groupSizes[i]).add(i);
            if(map.get(groupSizes[i]).size()==groupSizes[i]) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(map.get(groupSizes[i]));
                ans.add(temp);
                map.get(groupSizes[i]).clear();
            }
        }

        return ans;
    }
}