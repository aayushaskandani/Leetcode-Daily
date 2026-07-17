class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,int row,int col){
        if(row<0||col<0||row>=grid.length||col>=grid[0].length) return;
        //check if already water
        if(grid[row][col]=='0') return;

        //mark visited
        grid[row][col] = '0';
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}