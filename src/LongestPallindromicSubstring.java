public class LongestPallindromicSubstring {
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstr(str));
    }

    private static int longestPalSubstr(String str) {
        int n=str.length();
        int start=0;
        int maxLength=1;
        boolean sol[][]=new boolean[n][n];
        for(int i=0;i<n;i++){
            sol[i][i]=true;
        }
        for(int i=0;i<n-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                sol[i][i+1]=true;
                start=i;
                maxLength=2;
            }
        }
        for(int len =3;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j=i+len-1;
                if(sol[i+1][j-1]&& str.charAt(i)==str.charAt(j)){
                    sol[i][j]=true;
                    if(len>maxLength){
                        maxLength=len;
                        start=i;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start,
                start + maxLength - 1);
        return maxLength;
    }

    static void printSubStr(
            String str, int low, int high)
    {
        System.out.println(
                str.substring(
                        low, high + 1));
    }

}
