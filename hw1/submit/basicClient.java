import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class basicClient {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(
			Arrays.asList("1", "2", "3", "4"));
		permGenerator<String> myGenerator = new permGenerator<>(list);
		int numperm;
		for (int i = 0; i < 2; ++i) {
			numperm = 0;
                        List<String> t;
			while ((t = myGenerator.getNextPerm()) != null) {
				System.out.println(t);
				numperm += 1;
			}
			System.out.println(numperm);
			myGenerator.reset((l) -> (l.get(0) == "1"));
		}
	}
}
