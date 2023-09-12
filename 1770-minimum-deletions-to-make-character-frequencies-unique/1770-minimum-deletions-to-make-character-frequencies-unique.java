class Solution {
    public int minDeletions(String s) {
        int fre[] = new int[26],n = s.length();
        for(int i=0;i<n;i++)
        {
            fre[s.charAt(i)-'a']++;
        }

        Arrays.sort(fre);
       int ans = 0;
       for(int i=24;i>=0;i--)
       {
           if(fre[i]==0) break;
           if(fre[i]>0 && fre[i+1]==0)
           {
               ans+=fre[i];
               fre[i] = 0;
               continue;
           }
           if(fre[i]==fre[i+1])
           {
               fre[i] -= 1;
               ans++;
           }
           else if(fre[i]>fre[i+1])
           {
               ans+=(fre[i]-fre[i+1]+1);
               fre[i] = Math.max(0,fre[i+1]-1);
           }
           
       }

       return ans;
    }
}