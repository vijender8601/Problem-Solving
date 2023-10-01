class Solution {
    public String reverseWords(String s) {
        String a[] = s.split(" ");
        StringBuilder sb = new StringBuilder(),temp = new StringBuilder();

        for(String i : a)
        {
            if(sb.length()>0)sb.append(" ");

            temp = new StringBuilder(i);
            sb.append(temp.reverse());
        }

        return sb.toString();
    }
}