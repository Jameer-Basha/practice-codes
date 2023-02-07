class Solution {
    
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int no_of_islands=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' ){
                    no_of_islands ++;
                    grid=dfs(i,j,grid);
                }
            }
        }
        return no_of_islands;
    }
    public char[][] dfs(int row, int col,char[][]grids){
        int [] offsetr={-1,0,1,0};
        int [] offsetc ={0,-1,0,1};
        for (int i=0;i<4;i++){
            int nextr=row+offsetr[i];
            int nextc=col+offsetc[i];
            
            if(nextr<0 || nextc<0 || nextr>=grids.length ||  nextc>=grids[0].length){
                continue;
            }
            if(grids[nextr][nextc]=='1'){
                grids[nextr][nextc]='2';
                dfs(nextr,nextc,grids);
            }
        }
        return grids;
    }
}
