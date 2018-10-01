import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class UnitTest {

	public static void main(String[] args) {
		permGenerator<String> generator;
		ArrayList<String> list = new ArrayList<>(
			Arrays.asList("1", "2", "3", "4"));
		generator = new permGenerator<>(list);
		List<String> perm;
		HashSet<List<String>> generated = new HashSet<>();		
		while ((perm = generator.getNextPerm()) != null) {
			assert(perm.size() == 4);
			for (int i = 0; i < 4; ++i) {
				assert(perm.contains(String.valueOf(i+1)));
			}
			generated.add(perm);
		}
		assert(generated.size() == 24);

		System.out.println("Tests passed.");
	}
}
