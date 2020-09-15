public class Stairs {

    public static void main(String[] args) {
        System.out.println(stairs(4));
    }

    private static int stairs(int i) {
        if(i==1 || i==0){
            return 1;
        }
        return stairs(i-1)+stairs(i-2);
    }
}
