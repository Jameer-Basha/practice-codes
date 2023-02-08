/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.
*/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        image = dfs(image,sr,sc,image[sr][sc],color);
        image[sr][sc]=color;
        return image;
    }
    public int[][] dfs(int[][]image , int row, int col,int val,int color){
        int[] offsetr= {-1,0,1,0};
        int[] offsetc= {0,1,0,-1};
        for(int i=0;i<offsetr.length;i++){
            int nextr=row+offsetr[i];
            int nextc = col+offsetc[i];
            if(nextr<0 || nextc<0 || nextr>=image.length || nextc >= image[0].length)
                continue;
            if(image[nextr][nextc]==val && image[nextr][nextc]!=color){
                 image[nextr][nextc]=color;
                 dfs(image,nextr,nextc,val,color);
            }
        }
        return image;
    }
}
