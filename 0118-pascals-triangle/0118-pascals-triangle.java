class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        al.add(temp);
    // System.out.println(al);
        for(int i=2;i<=numRows;i++)
        {
            temp = new ArrayList<>();
            temp.add(1);
            for(int j=2;j<i;j++)
            {
                temp.add(al.get(i-2).get(j-1)+al.get(i-2).get(j-2));
            }
            temp.add(1);
            al.add(temp);
            // if(i==2) break;
        }
        // System.out.println(al+" "+temp);
        return al;
    }
}