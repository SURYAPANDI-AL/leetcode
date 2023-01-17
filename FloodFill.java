class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int variable=image[sr][sc];
        image[sr][sc]=color;
        //left
        if(sc-1>-1&&image[sr][sc-1]==variable)
        floodFill(image,sr,sc-1,color);
        //right
        if(sc+1<image[0].length&&image[sr][sc+1]==variable)
        floodFill(image,sr,sc+1,color);
        //top
        if(sr-1!=-1&&image[sr-1][sc]==variable)
        floodFill(image,sr-1,sc,color);
        //bottom
        if(sr+1!=image.length&&image[sr+1][sc]==variable)
        floodFill(image,sr+1,sc,color);
        return image;
    }
}
