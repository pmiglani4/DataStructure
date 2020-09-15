public class EditDistance {
    public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(editDist(str1, str2, str1.length(), str2.length()));
        System.out.println("DP solution:"+ editDistDP(str1, str2, str1.length(), str2.length()));
    }

    private static int editDistDP(String str1, String str2, int m, int n) {
        int DP[][] = new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                if(i==0){
                    DP[i][j]=j;
                }
                else if(j==0){
                    DP[i][j]=i;
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    DP[i][j]=DP[i-1][j-1];
                }else{
                    DP[i][j]=1+Math.min(Math.min(DP[i-1][j-1], DP[i][j-1]),DP[i-1][j]);
                }
            }
        }
        return DP[m][n];
    }

    private static int editDist(String str1, String str2, int m, int n) {
        if (m==0){
            return n;
        }
        if (n==0){
            return  m;
        }
        if(str1.charAt(m-1)==str2.charAt(n-1)){
            return editDist(str1,str2, m-1, n-1);
        }
        return 1+ Math.min( Math.min(editDist(str1,str2, m-1, n-1),
                editDist(str1,str2, m, n-1)),
                editDist(str1, str2, m-1, n));

    }
}
