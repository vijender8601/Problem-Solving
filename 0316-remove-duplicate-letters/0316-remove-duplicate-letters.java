class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int vis[] = new int[26];
        int ind[] = new int[26];
        for(int i=0;i<n;i++) ind[s.charAt(i)-'a'] = i;
        Stack<Character>st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && vis[s.charAt(i)-'a']==0 && st.peek()>=s.charAt(i) && ind[st.peek()-'a']>=i)
            {
                vis[st.pop()-'a']= 0;
            }
            if(vis[s.charAt(i)-'a']==0)
            {
                vis[s.charAt(i)-'a'] = 1;
                st.push(s.charAt(i));
            }
        }

        String ans = "";
        while(!st.isEmpty())
        {
            ans=st.pop()+""+ans;
        }

        return ans;

    }
}