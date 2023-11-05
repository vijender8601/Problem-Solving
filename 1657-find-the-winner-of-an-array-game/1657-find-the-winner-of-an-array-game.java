class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int nge[] = new int[n];
        Arrays.fill(nge,n);
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[i]>arr[st.peek()]) st.pop();
            nge[i] = (st.isEmpty())?n:st.peek();
            st.push(i);
        }
        int max = 0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>max && nge[i]==n) return arr[i];
            if(nge[i]-i-1>=(i==0?k:k-1) && max<arr[i]) return arr[i];
            max = Math.max(max,arr[i]);
        }

        return -1;
    }
}