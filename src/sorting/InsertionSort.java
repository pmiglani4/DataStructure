package sorting;

/**
 * In insertion sort, we start with index=1 (since index at 0 is sorted as it is the only element in array.
 * Iteration 1 : element[1] is compared to element[0], if element[1] is less than element[0], these are swapped.
 * Iteration 2 : Element[2] is picked and compared to element[1] and element[0] and placed in its correct location
 * Iteration 3 : element[3] is picked and compared with element[2]..element[0] and placed in its correct location
 * This is an in-place algorithm. Time Complexity - O(n power 2).
 *
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22, 75};

        insertionSort(array);

        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
        int[] array1 = {20, 35, -15, 7, 55, 1, -22, 75};

        insertionSort1(array1);

        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    private static void insertionSort(int[] array) {

        for(int i =1; i < array.length; i++) {

            for (int j = i; j > 0; j--) {

                if (array[j] < array[j-1]) {
                    // swap these two elements
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
    /*
     Insertion sort takes maximum time to sort if elements are sorted in reverse order.
     And it takes minimum time (Order of n) when elements are already sorted
     */
    private static void insertionSort1(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

}
