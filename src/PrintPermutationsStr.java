public class PrintPermutationsStr {

    public static void printPermutation(String str, String ans)
    {
        if(str.length()==0){
            System.out.print(ans+" ");
            return;
        }
        boolean alpha[] = new boolean[26];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String ros= str.substring(0,i)+str.substring(i+1, str.length());
            if(alpha[ch-'a']==false)
                printPermutation(ros, ans+ch);
            alpha[ch-'a']=true;
        }
    }
    public static void main(String[] args)
    {
        String s = "abb";
        printPermutation(s, "");
    }
}
