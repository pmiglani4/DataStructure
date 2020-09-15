import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Iterator<Integer> itr = integers.iterator();
        while (itr.hasNext()) {
            Integer a = itr.next();
            System.out.println(a);
            integers.set(2,4);
        }
        System.out.println(integers.size());
    }
}
