package wangyi;

public class One {
    public static boolean[][] vised;
    public static int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
    public static int ans;
    public static void dfs(int[][] grid,int x,int y,int cost){
        if(x == grid.length-1 && y == grid[0].length - 1){
            ans = Math.min(ans,cost);
        }
        vised[x][y] = true;
        for(int[] dir:dirs){
            int newx = x + dir[0];
            int newy = y+ dir[1];
            if(newx>=0 && newx< grid.length && newy >=0 &&newy<grid[0].length&&!vised[newx][newy]){
                int thisCost = grid[newx][newy] == 0? 2:1;
                dfs(grid,newx,newy,cost + thisCost);
            }
        }
        vised[x][y] = false;
    }
    public static int calcMinSailCost (int[][] input) {
        // write code here\
        vised = new boolean[input.length][input[0].length];
        ans = Integer.MAX_VALUE;
        //int cost = 0;
        dfs(input,0,0,0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calcMinSailCost(null));
    }
}
