
public class FindPerfectSquareRoot {

    public static void main(String[] args) {
        System.out.println(squareRoot(100));
        System.out.println(squareRoot(1000));
        System.out.println(squareRoot(10000));
        System.out.println(squareRoot(36));
    }

    private static int squareRoot(int number) {
        return squareRootInternal(number, 0, number);
    }

    private static int squareRootInternal(int number, int start, int end) {

        if (start < end) {
            int mid = (start+end)/2;

            if (mid*mid == number) {
                return mid;
            } else if (mid*mid > number) {
                return squareRootInternal(number, start, mid);
            } else {
                return squareRootInternal(number, mid+1, end);
            }
        } else {
            return -1;
        }

    }
}
