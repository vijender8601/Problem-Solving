class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length,m = board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]!=word.charAt(0)) continue;

                if(dfs(i,j,0,board,word,new int[n][m])) return true;
            }
        }

        return false;
    }

    boolean dfs(int i,int j, int k,char board[][],String word,int vis[][])
    {
         if(k==word.length()) return true;

        if(i<0 || j<0 || i>=board.length || j>=board[0].length || word.charAt(k)!=board[i][j] || vis[i][j]==1) return false;
       
        int dx[] = {0,0,1,-1},dy[] = {1,-1,0,0};
        vis[i][j] = 1;
        boolean ans = false;
        for(int x=0;x<4;x++)
        {
            ans |= dfs(i+dx[x],j+dy[x],k+1,board,word,vis);
        }
        vis[i][j] = 0;
        return ans;
    }
}





