public class CoinChange {

    // Returns the count of ways we can
    // sum S[0...m-1] coins to get sum n
    static int count( int S[], int m, int n )
    {
        if(n==0)
            return 1;
        if(n<1)
            return 0;
        if(m<=0&&n>=1)
            return 0;
        return count(S,m-1,n)+count(S, m, n-S[m-1]);
    }
    static int countDP( int S[], int m, int n ){

        int sol[][]=new int[n+1][m];
        for(int i=0;i<m;i++){
            sol[0][i]=1;
        }
        int x,y;
        for(int i=1;i<=n;i++){
            for(int j=0;j<m;j++){
                // Count of solutions including S[j]
                x = i-S[j]>=0 ? sol[i-S[j]][j] : 0;
                // Count of solutions excluding S[j]
                y = (j>=1)?sol[i][j-1]:0;
                sol[i][j]=x+y;
            }
        }
        return  sol[n][m-1];

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int m = arr.length;
        System.out.println( count(arr, m, 4));
        System.out.println( countDP(arr, m, 4));
    }
}
