class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character,TreeSet<Integer>> map = new HashMap<>();
        int n = s.length(),cnt = 0;
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(s.charAt(i))) {map.put(s.charAt(i),new TreeSet<>());}
            map.get(s.charAt(i)).add(i);
        }

        cnt = map.size();

        StringBuilder sb = new StringBuilder();
        int ind = -1;
        while(cnt>0){
            outer : for(char i='a';i<='z';i++)
            {
                if(map.containsKey(i)==false) continue;
                Integer key = map.get(i).ceiling(ind+1);
                for(char j='a';j<='z';j++)
                {
                    if(i==j || map.containsKey(j)==false) continue;
                    if(map.get(j).ceiling(key)==null) continue outer;
                }
                sb.append(i);
                map.remove(i);
                ind = key;
                break;
            }
            cnt--;
        }

        return sb.toString();
    }
}