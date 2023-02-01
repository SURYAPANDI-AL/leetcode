class Solution {
    public int countBattleships(char[][] board) {
        boolean [] check1=new boolean[board[0].length];
        boolean [] check2=new boolean[board.length];
        int count=0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                
                if(board[i][j]=='X'&&!(check1[j])&&!(check2[i]))
                {
                    count++;
                    check1[j]=true;
                    check2[i]=true;
                }
                else if(board[i][j]=='.')
                {
                    check1[j]=false;
                    check2[i]=false;
                }
            }
        }
        return count;
    }
}
