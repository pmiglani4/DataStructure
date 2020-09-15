import java.util.Queue;
import java.util.LinkedList;

public class RotOranges {
    public final static int R = 3;
    public final static int C = 5;
    static class Ele
    {
        int x = 0;
        int y = 0;
        Ele(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)
    {
        int arr[][] = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = rotOranges(arr);
        if(ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }
    // function to check whether a cell is valid / invalid
    static boolean isValid(int i, int j)
    {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }
    static boolean isDelim(Ele temp)
    {
        return (temp.x == -1 && temp.y == -1);
    }
    static class Flag{
        boolean value;
    }
    static class Result{
        Integer ans=0;
    }

    static int rotOranges(int arr[][]){
// Create a queue of cells
        Queue<Ele> Q= new LinkedList<Ele>();
        Result result = new Result();
        // Store all the cells having rotten orange in first time frame
        for (int i=0; i < R; i++)
            for (int j=0; j < C; j++)
                if (arr[i][j] == 2)
                    Q.add(new Ele(i,j));

         Q.add(new Ele(-1, -1));
        Ele temp;
        while (!Q.isEmpty()){
            Flag flag=new Flag();
            while (!isDelim(Q.peek())){
                temp=Q.peek();
                rotOrange(arr, temp.x+1, temp.y, Q, flag, result);
                rotOrange(arr, temp.x-1, temp.y, Q, flag, result);
                rotOrange(arr, temp.x, temp.y+1, Q, flag, result);
                rotOrange(arr, temp.x, temp.y-1, Q, flag, result);
                Q.remove();
            }
            Q.remove();
            if (!Q.isEmpty())
            {
                Q.add(new Ele(-1,-1));
            }
        }
        return (checkAll(arr))? -1: result.ans;
    }
    static boolean checkAll(int arr[][])
    {
        for (int i=0; i<R; i++)
            for (int j=0; j<C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }

    private static void rotOrange(int[][] arr, int x, int y, Queue<Ele> q, Flag flag, Result result) {
        if(isValid(x,y)&&arr[x][y]==1){
            arr[x][y]=2;
            q.add(new Ele(x,y));
            if(flag.value==false){
                flag.value=true;
                result.ans=result.ans+1;
            }
        }
    }
}
