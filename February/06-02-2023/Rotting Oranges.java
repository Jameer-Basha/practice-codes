/* 

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

*/
class Solution {
    
    public int orangesRotting(int[][] grid) {
        //Pair pair=new Pair();
        Queue<Pair> que = new LinkedList<Pair>();
        int countFresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    que.offer(new Pair(i,j));
                else if(grid[i][j]==1)
                    countFresh+=1;
            }
        }
        int time=0;
        int[] offsetr={-1,0,1,0};
        int[] offsetc ={0,1,0,-1};
        if(countFresh==0)
            return 0;
        while(!que.isEmpty()){
            int size= que.size();
            
            for(int i=0;i<size;i++){
                Pair curr = que.poll();
                int r= curr.row;
                int c = curr.col;
                for(int j=0;j<4;j++){
                    int nextr=r+offsetr[j];
                    int nextc=c+offsetc[j];
                    
                    if(nextr<0 || nextr>=grid.length || nextc<0 || nextc>=grid[0].length)
                        continue;
                    if(grid[nextr][nextc]==1){
                        
                            que.offer(new Pair(nextr,nextc));
                            grid[nextr][nextc]=2;
                        countFresh-=1;
                            
                        
                    }
                }
            }
            time+=1;
            
        }
     if(countFresh==0)
        return time-1;
    else
        return -1;
    }
  
        
    }

class Pair{
    int row;
    int col;
    Pair(int row ,int col){
        this.row= row;
        this.col = col;
    }
}
