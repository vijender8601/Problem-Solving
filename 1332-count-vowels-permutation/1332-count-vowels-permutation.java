class Solution {
    public int countVowelPermutation(int n) {
        if(n==1) return 5;

        long ans = 0,mod = (long)1e9+7;

        Map<Character,Long> map = new HashMap<>(),temp = new HashMap<>();
        map.put('a',1l);
        map.put('e',1l);
        map.put('i',1l);
        map.put('o',1l);
        map.put('u',1l);

        for(int i=2;i<=n;i++)
        {
            long val = (map.get('e')+map.get('i')+map.get('u'))%mod;
            temp.put('a',val);

            val = (map.get('a')+map.get('i'))%mod;
            temp.put('e',val);

            val = (map.get('e')+map.get('o'))%mod;
            temp.put('i',val);

            val = (map.get('i'))%mod;
            temp.put('o',val);
            val = (map.get('o')+map.get('i'))%mod;
            temp.put('u',val);

            for(char c : map.keySet())
            {
                map.put(c,temp.get(c));
            }
        }

        for(char c : map.keySet())
        {
            ans+=map.get(c);
            ans%=mod;
        }

        return (int)(ans%mod);
    }   
}