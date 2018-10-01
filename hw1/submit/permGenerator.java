import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock; 
import java.util.function.Predicate;
import java.lang.IllegalArgumentException;

public class permGenerator<T> {

	/* current state of list permutation */
	private List<T> list;
	/* copy of original list order at construction time */
	private List<T> originalList;

	/* data structures used for Heap's algorithm */
	private int[] counters;
	private int i;
	private int n;
	private boolean startflag;

	/* synchronizer */
	private ReentrantLock lock;

	/* predicate to select valid permutation */
        private Predicate<List<T>> predicate;

	/**
	 * Constructor with default Predicate (always true).
	 *
	 * @param list A non-empty List object whose elements' permutations are to be generated.
	 */
	public permGenerator(List<T> list) {
		if (list.size() == 0) {
			throw new IllegalArgumentException("Input list size cannot be 0.");
		}
		this.originalList = new ArrayList<>(list);
		this.list = new ArrayList<>(this.originalList);
		this.n = list.size();
		this.i = 0;
		this.counters = new int[this.n];
		Arrays.fill(this.counters, 0);
		this.startflag = true;
		this.lock = new ReentrantLock();
                this.predicate = (l) -> true;
	}

	/**
	 * Constructor with user defined Predicate, which calls the above constructor.
	 *
	 * @param list A non-empty List object whose elements' permutations are to be generated.
	 * @param predicate User defiend predicate.
	 */
        public permGenerator(List<T> list, Predicate<List<T>> predicate) {
		this(list);
                this.predicate = predicate;
	}

	/**
	 * Reset the generator to initial state, with the order being the same as the
	 * list used to construct this generator and the predicate unchanged.
	 * 
	 * This function is thread-safe.
	 *
	 * @return Void.
	 */
	public void reset() {
		this.lock.lock();
		this.startflag = true;
		this.i = 0;
		Arrays.fill(this.counters, 0);
		this.list = new ArrayList<>(this.originalList);
		this.lock.unlock();
	}

	/**
	 * Reset the generator to initial state and set its predicate, with the order
	 * being the same as the list used to construct this generator.
	 *
	 * This function is thread-safe.
	 *
	 * @return Void.
	 */
	public void reset(Predicate<List<T>> predicate) {
		this.lock.lock();
		this.reset();
		this.predicate = predicate;
		this.lock.unlock();
	}

	/**
	 * Generate a new permutation.
	 *
	 * Generate the next permutation decided by the Heap's algorithm. This function
	 * is thread safe in the sense that multiple threads can call this method of the
	 * same generator simultaneously and get valid results.
	 *
	 * @return A copy of the List representing this new permutation. null if there is
	 * no more permutation to generate.
	 */
	public List<T> getNextPerm() {
		this.lock.lock();
		if (this.startflag) {
			this.startflag = false;
                        if (this.predicate.test(new ArrayList<>(this.list))) {
				this.lock.unlock();
				return new ArrayList<>(this.list);
			}
		}
		while (this.i < this.n) {
			if (this.counters[i] < this.i) {
				if (this.i % 2 == 0) {
					T tmp = this.list.get(0);
					this.list.set(0, this.list.get(this.i));
					this.list.set(this.i, tmp);
				} else {
					T tmp = this.list.get(this.counters[this.i]);
					this.list.set(this.counters[this.i], this.list.get(this.i));
					this.list.set(this.i, tmp);
				}
				this.counters[this.i] += 1;
				this.i = 0;
                                if (this.predicate.test(new ArrayList<>(this.list))) {
				    this.lock.unlock();
				    return new ArrayList<>(this.list);
                                }
			} else {
				this.counters[this.i] = 0;
				this.i += 1;
			}
		}
		this.lock.unlock();
		return null;
	}
}
