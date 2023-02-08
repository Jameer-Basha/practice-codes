/* In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold. */

class Solution {
    int[] offsetr={-1,0,1,0};
    int[] offsetc={0,1,0,-1};
    public int getMaximumGold(int[][] grid) {
        int max=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                max=Math.max(max,findMax(grid,rows,cols,i,j));
            }
        }
        return max;
    }
    public int findMax(int[][] grid,int rows, int cols,int prow,int pcol){
        if(prow<0 || prow>=rows || pcol<0 || pcol>=cols || grid[prow][pcol]==0)
                return 0;
        int max=0;
        int original = grid[prow][pcol];
        grid[prow][pcol]=0;
        for(int i=0;i<4;i++){
            int nextr=prow+offsetr[i];
            int nextc=pcol+offsetc[i];
            max =Math.max(max,findMax(grid,rows,cols,nextr,nextc));
        }
        grid[prow][pcol]=original;
        return max+original;
    }
}
