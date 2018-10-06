import java.util.*;

public class Clientcode {
        public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("Printing all permutations using a Collection style");

        int count = 0;
        //for (List<Integer> perm : Permutations.of(mylist)) {
        //    count += 1;
        //    System.out.println(perm);
        //}
        List<List<Integer>> perms = (List<List<Integer>>)Permutations.of(mylist);
        for (int i = 0; i < perms.size() - 4; i++) {
            count += 1;
            System.out.println(perms.get(i));
        }
        System.out.println(count);
    }
}
