import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;

public class concurrentClient extends Thread {

	private static ArrayList<String> list = new ArrayList<>(
		Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
	private static permGenerator<String> myGenerator = new permGenerator<>(list);

	private int id;

	public concurrentClient(int id) {
		this.id = id;
	}

	public void run() {
		int local_count = 0;
		List<String> t;
		while ((t = myGenerator.getNextPerm()) != null) {
			local_count += 1;
		}
		System.out.println(this.id + ":" + local_count);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 3; ++i) {
			(new concurrentClient(i)).start();
		}
	}
}
