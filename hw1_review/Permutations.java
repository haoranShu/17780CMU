import java.util.*;

public class Permutations {

    private static final int sizeLimit = 12;

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; ++i) {
            result *= i;
        }

        return result;
    }

    public static <T> Collection<List<T>> of(Collection<T> elements) {
        if (elements.size() > sizeLimit) {
            throw new IllegalArgumentException("Permutations too many " + elements);
        }

        ArrayList<T> list = new ArrayList<>(elements);
        /* a convenient member for contains() */
        HashSet<T> set = new HashSet<>(elements);

        return new AbstractList<List<T>>() {
	    /* data structures used for Heap's algorithm */
	    private int i = 0;
	    private int n = list.size();
	    private int[] counters = new int[n];
	    private boolean startflag = true;

            @Override public int size() {
                return factorial(list.size());
            }

            @Override public boolean contains(Object o) {
                return o instanceof List && set.equals(new HashSet<>((List)o));
            }

            @Override public List<T> get(int index) {
                return new ArrayList<>(list);
            }

            class PermutationIterator implements Iterator<List<T>> {
                @Override public boolean hasNext() {
                    if (startflag) {
                        Arrays.fill(counters, 0);
                        startflag = false;
		    		    return true;
		    	    }

		            while (i < n) {
        		    	if (counters[i] < i) {
		    		        if (i % 2 == 0) {
		    			        T tmp = list.get(0);
		    			        list.set(0, list.get(i));
		    			        list.set(i, tmp);
		    		        } else {
		    			        T tmp = list.get(counters[i]);
		    			        list.set(counters[i], list.get(i));
		    			        list.set(i, tmp);
		    		        }
		    		        counters[i] += 1;
		    		        i = 0;
		    		        return true;
		    	        } else {
		    	        	counters[i] = 0;
		    		        i += 1;
		    	        }
		            }

                    return false;
                }

                @Override public List<T> next() {
                    return new ArrayList<>(list);
                }
            }

            @Override public Iterator<List<T>> iterator() {
                return new PermutationIterator();
            }
        };
    }
}
