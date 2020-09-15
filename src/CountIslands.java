public class CountIslands {

    public static void main(String[] args) throws java.lang.Exception
    {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        System.out.println("Number of islands is: " + countIslands(M));
    }

    private static Integer countIslands(int[][] m) {
        int rows= m.length;
        int cols=m[0].length;
        boolean visited[][]= new boolean[rows][cols];
        int count=0;
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if(m[i][j]==1 && !visited[i][j]){
                    DFS(m, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static int rowNbr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static  int colNbr[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static void DFS(int[][] m, int i, int j, boolean[][] visited) {
        visited[i][j]=true;
        for (int k=0;k<8;k++){
            if(isSafe(m, i+rowNbr[k], j+colNbr[k], visited) && m[i+rowNbr[k]][j+colNbr[k]]==1)
                    DFS(m, i+rowNbr[k], j+colNbr[k], visited);
        }
    }

    private static boolean isSafe(int[][] m, int i, int j, boolean[][] visited){
        int rows= m.length;
        int cols=m[0].length;
        if(i>=0 &&i <rows && j>=0 && j<cols && !visited[i][j]){
            return true;
        }
        return false;
    }
}
