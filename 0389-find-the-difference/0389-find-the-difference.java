class Solution {
    public char findTheDifference(String s, String t) {
        int fre[] = new int[26];
        for(char i : s.toCharArray())
        {
            fre[i-'a']++;
        }

        for(char i : t.toCharArray())
        {
            fre[i-'a']--;
        }

        int ans = 0;
        for(int i=0;i<26;i++)
        {
            if(fre[i]==-1) ans = i;
        }

        return (char)(ans+'a');
    }
}