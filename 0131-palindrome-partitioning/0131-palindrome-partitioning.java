class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        helper(s,0,new ArrayList<String>());
        return ans;
    }

    public void helper(String s,int i,List<String> bl)
    {
        if(i==s.length())
        {
            ans.add(bl);
            return;
        }

        for(int j=i;j<s.length();j++)
        {
            if(isPalin(s.substring(i,j+1)))
            {
                List<String> al = new ArrayList<>();
                al.addAll(bl);
                al.add(s.substring(i,j+1));
                helper(s,j+1,al);
            }
        }
    }

    private boolean isPalin(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
}