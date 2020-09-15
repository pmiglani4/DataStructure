public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[] = new int[] {2, 40, 2, 40, 5};
        int n = arr.length;

        System.out.println("Minimum number of multiplications is "+
                MatrixChainOrder(arr, 1, n-1));
        System.out.println("Minimum number of multiplications through DP is "+
                MatrixChainOrderDP(arr,n));
    }

    private static int MatrixChainOrder(int[] arr, int i, int j) {
        if(i==j){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int count = MatrixChainOrder(arr, i, k)+MatrixChainOrder(arr,k+1, j )+arr[i-1]*arr[k]*arr[j];
            if(count<min){
                min=count;
            }
        }
        return min;
    }
    private static int MatrixChainOrderDP(int[] arr, int n) {
        int sol[][]=new int[n][n];
        for (int i=1;i<n;i++){
            sol[i][i]=0;
        }
        for(int L=2;L<n;L++){
            for(int i=1;i<n-L+1;i++){
                int j=i+L-1;
                if(j==n)
                    continue;
                sol[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int count = sol[i][k]+sol[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    if(sol[i][j]>count){
                        sol[i][j]=count;
                    }
                }
            }
        }
        return sol[1][n-1];
    }
}
