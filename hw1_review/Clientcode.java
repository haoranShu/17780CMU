import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Clientcode {
        public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("Printing all permutations using a Collection style");

        int count = 0;
        for (List<Integer> perm : Permutations.of(mylist)) {
            count += 1;
            System.out.println(perm);
        }
        System.out.println(count);
    }
}
