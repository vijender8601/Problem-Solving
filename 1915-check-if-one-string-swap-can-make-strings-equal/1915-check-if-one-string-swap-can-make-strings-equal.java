class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int cnt = 0;
        int fre[] = new int[26];
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i)) cnt++;
            fre[s1.charAt(i)-'a']++;
            fre[s2.charAt(i)-'a']--;
        }
        for(int i : fre) if(i!=0) return false;
        return (cnt==2 || cnt==0); 
    }
}