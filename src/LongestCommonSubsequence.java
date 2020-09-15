public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs( X, Y, m, n ) );
        System.out.println("Length of LCS-DP is" + " " +
                lcsDP( X, Y, m, n ) );
    }

    private static int lcs( char[] X, char[] Y, int m, int n ) {
        if(m==0 || n==0){
            return 0;
        }
        if(X[m-1]==Y[n-1]){
           return 1+lcs(X,Y,m-1, n-1);
        }
        return Math.max(lcs(X,Y,m-1, n), lcs(X,Y, m, n-1));
    }

    private static int lcsDP( char[] X, char[] Y, int m, int n ) {
        int sol[][]= new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    sol[i][j]=0;
                }else if(X[i-1]==Y[j-1]){
                    sol[i][j]=1+sol[i-1][j-1];
                }else{
                    sol[i][j]=Math.max(sol[i-1][j],sol[i][j-1]);
                }

            }
        }
        return sol[m][n];
    }
}
