public class RotatedArraySearch {
    public static void main(String args[])
    {
        int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int n = arr.length;
        int key = 2;
        int i = search(arr, 0, n - 1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
        System.out.println("Pivot index is"+findPivot(arr, 0, n-1));
    }
    // Returns index of key in arr[l..h]
    // if key is present, otherwise returns -1
    static int search(int arr[], int l, int h, int key)
    {
        if(h<l){
            return -1;
        }
        int mid = (l+h)/2;
        if(arr[mid]==key){
            return mid;
        }
        if(arr[l]<=arr[mid]){
            if(key>=arr[l]&&key<=arr[mid])
                return search(arr, l, mid-1, key);
            return search(arr, mid+1, h, key);
        }

        if(key>=arr[mid]&&key<=arr[h]){
            return search(arr, mid+1, h, key);
        }
        return search(arr, l, mid-1, key);
    }

    /* Function to get pivot. For array
       3, 4, 5, 6, 1, 2 it returns
       3 (index of 6) */
    static int findPivot(int arr[], int low, int high)
    {
        if(high<low){
            return -1;
        }
        if(high==low){
            return low;
        }
        int mid= (low+high)/2;
        if(arr[mid]>arr[mid+1]){
            return mid;
        }
        if (arr[mid]<arr[mid-1]){
            return mid-1;
        }
        if(arr[low]<=arr[mid]){
            return findPivot(arr, mid+1, high);
        }
        return findPivot(arr,low,mid-1 );
    }
}
