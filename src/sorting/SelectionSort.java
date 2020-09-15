package sorting;

/**
 * Traverse the array, find largest element and replace it with last unsorted index.
 * last_unsorted_index = last index until which array is sorted.
 * In place algorithm with O(n power 2) time complexity.
 * Does not require as much sorting as bubble sort. Better than Bubble sort.
 *
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};

        selectionSort(array, 0, array.length-1);

        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
        int[] array1 = {20, 35, -15, 7, 55, 1, -22};

        selectionSort(array1);

        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    private static void selectionSort(int[] array, int start, int end) {

        int j = end;
        while(start < end) {

            int maxElement = array[0];
            int maxIndex = 0;
            for (int i = 1; i <= j; i++) {
                if (maxElement < array[i]) {
                    maxElement = array[i];
                    maxIndex = i;
                }
            }
           int temp = array[maxIndex];
            array[maxIndex] = array[j];
            array[j] = temp;
            j--;
            start++;
        }
    }

    private static void selectionSort(int[] array){
        int n=array.length;
        for(int i=n-1;i>0;i--){
            int maxIndex=0;
            int max=array[0];
            for(int j=1;j<=i;j++){
                if(max<array[j]){
                    max=array[j];
                    maxIndex=j;
                }
            }
            int temp=array[maxIndex];
            array[maxIndex]=array[i];
            array[i]=temp;
        }
    }
}
