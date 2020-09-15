public class LongestPallidromicSubsequence {
    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.printf("The length of the LPS is %d", lps(seq.toCharArray(), 0, n - 1));
        System.out.printf("The length of the LPS is %d", lpsDP(seq));

    }

    private static int lps(char[] charSeq, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (charSeq[i] == charSeq[j] && i + 1 == j) {
            return 2;
        }
        if (charSeq[i] == charSeq[j]) {
            return lps(charSeq, i + 1, j - 1) + 2;
        }
        return Math.max(lps(charSeq, i, j - 1), lps(charSeq, i + 1, j));

    }

    static int lpsDP(String seq) {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];

        for (i = 0; i < n; i++)
            L[i][i] = 1;
        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j=i+cl-1;
                if((seq.charAt(i)==seq.charAt(j)) && cl==2)
                    L[i][j]=2;
                else if(seq.charAt(i) == seq.charAt(j))
                    L[i][j]=2+L[i+1][j-1];
                else
                    L[i][j]=Math.max(L[i][j-1],L[i+1][j]);
            }
        }
        return L[0][n-1];

    }
}
