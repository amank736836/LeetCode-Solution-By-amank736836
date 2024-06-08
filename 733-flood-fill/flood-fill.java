class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFill(image,sr,sc,color,image[sr][sc]);
        return image;
    }

    public void floodFill(int [][] image,int row,int col,int newColor,int startColor){
        if(row<0 || col <0 || row>=image.length || col>=image[0].length || image[row][col] != startColor){
            return;
        }
        if(image[row][col] != newColor){
            image[row][col] = newColor;
            floodFill(image,row+1,col,newColor,startColor);
            floodFill(image,row-1,col,newColor,startColor);
            floodFill(image,row,col+1,newColor,startColor);
            floodFill(image,row,col-1,newColor,startColor);
        }
    }
}