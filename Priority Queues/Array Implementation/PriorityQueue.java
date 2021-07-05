/* An array-based implementation of a priority queue. */
public class PriorityQueue {
	private int maxSize;
	private long[] queueArray;
	private int nItems;
	
	public PriorityQueue(int size) {
		maxSize = size;
		queueArray = new long[maxSize];
		nItems = 0;
	}
	
	/* Iteratively insert in non-ascending order: Biggest value is stored at the rear (index 0) and the smallest 
	 * or min value is stored at the front (index n-1). */
	public void insert(long item) {
		int i;
		if (nItems == 0)
			queueArray[nItems++] = item;
		else {
			for (i=nItems-1; i >= 0; i--) {
				if (item > queueArray[i])
					queueArray[i+1] = queueArray[i]; // Shift to right.
				else
					break;
			}
			queueArray[i+1] = item;
			nItems++;
		}
	}
	
	public long remove() {
		return queueArray[--nItems]; // Remove item at front with min value.
	}
	
	public long peekMin() {
		return queueArray[nItems-1];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
}
