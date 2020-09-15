package sorting;

/**
 * In Bubble sort, largest element is bubbled to the right of the array in each iteration.
 * Performance degrades quickly as the number of elements to sort increase.
 * In place algorithm.  O(n raised to power 2) time complexity
 * This algo is not practically
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};

        bubbleSort(array, 0, array.length-1);

        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
        int[] array1 = {20, 35, -15, 7, 55, 1, -22};

        bubbleSort(array1);

        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    //Both Best Case and Worst case complexity is O(n*n)
    private static void bubbleSort(int[] array, int start, int end) {

        int j = end;
        while (start < end) {

            for(int i=0; i<j; i++) {

                if (array[i] > array[i+1]) {
                    // swap the values
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            start++;
            j--;
        }

    }

    //Worst Case complexity is O(n*n) & Best Case Complexity is O(n) when array is already sorted
    private static void bubbleSort(int[] array){
        int n= array.length;
        int temp;
        boolean swapped;
        for(int i=n-1;i>0;i--){
            swapped=false;
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    swapped=true;
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}
