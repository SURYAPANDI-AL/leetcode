class MaxAreaIsland {
    public static int island(int row,int column,int [][] grid){
        int count=1;
        if(grid[row][column]==0||grid[row][column]==2) return 0;
        //left
        grid[row][column]=2;
        if(column-1>-1&&grid[row][column-1]==1)
        count+=island(row,column-1,grid);
        //right
        if(column+1<grid[0].length&&grid[row][column+1]==1)
        count+=island(row,column+1,grid);
        //top
        if(row-1>-1&&grid[row-1][column]==1)
        count+=island(row-1,column,grid);
        //bottom
        if(row+1<grid.length&&grid[row+1][column]==1)
        count+=island(row+1,column,grid);

        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int highestValue=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int temp=island(i,j,grid);
                    if(temp>highestValue)
                    highestValue=temp;
                }
            }
        }

        return highestValue;
    }
}
