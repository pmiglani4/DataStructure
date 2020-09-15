public class EggDrop {
    public static void main(String[] args) {
        int n = 2, k = 36;
        System.out.println("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDrop(n, k));

        System.out.println("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDropDP(n, k));
    }

    private static int eggDrop(int n, int k) {
        if(k==1||k==0){
            return k;
        }
        if(n==1){
            return k;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            int res =1+ Math.max(eggDrop(n-1, i-1), eggDrop(n, k-i));
            if(res<min){
                min=res;
            }
        }
        return min;
    }

    private static int eggDropDP(int n, int k) {
        int sol[][]=new int[n+1][k+1];

        for(int i=0;i<n;i++){
            sol[i][0]=0;
            sol[i][1]=1;
        }
        for(int j=1;j<=k;j++){
            sol[1][j]=j;
        }

        for(int i=2;i<=n;i++){
            for(int j=2;j<=k;j++){
                int min=Integer.MAX_VALUE;
                for(int x=1; x<=j;x++){
                    int res =1+ Math.max(sol[i-1][x-1], sol[i][j-x]);
                    if(res<min){
                        min=res;
                    }
                }
                sol[i][j]=min;
            }
        }
        return sol[n][k];
    }
}
