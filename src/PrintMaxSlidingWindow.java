import java.util.Deque;
import java.util.LinkedList;

public class PrintMaxSlidingWindow {
    public static void main(String[] args)
    {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        printMax(arr, arr.length, k);
    }

    private static void printMax(int[] arr, int length, int k) {
        Deque<Integer> q=new LinkedList<>();
        int i=0;
        for (;i<k;i++){
            while (!q.isEmpty()&&arr[i]>=arr[q.peekLast()]){
                q.removeLast();
            }
            q.add(i);
        }

        for (;i<length;i++){
            System.out.println(arr[q.peekFirst()]);
            while (!q.isEmpty()&&q.peek()<=i-k){
                q.removeFirst();
            }
            while ((!q.isEmpty()&&arr[i]>=arr[q.peekLast()])){
                q.removeLast();
            }
            q.add(i);
        }
        System.out.print(arr[q.peek()]);
    }
}
