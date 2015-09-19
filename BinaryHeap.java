import java.util.ArrayList;


/**
 * A class that represents a Binary Heap data structure
 * @author kuhnerdm
 *
 */
public class BinaryHeap<T extends Comparable<? super T>> {
	//Instance variables
	ArrayList<T> array;
	int size;
	
	/**
	 * Construct an empty BinaryHeap
	 */
	public BinaryHeap() {
		array = new ArrayList<T>();
		array.add(null);
		this.size = 0;
	}
	
	/**
	 * Converts a BinaryHeap to a string
	 * @return String representing the BinaryHeap
	 */
	public String toString() {
		return array.toString();
	}
	
	/**
	 * Inserts a new element to the BinaryHeap
	 * @param element The element to be inserted
	 */
	public void insert(T element) {
		if(this.size == 0) {
			array.add(element);
			this.size++;
			return;
		}
		
		array.add(null);
		int hole = ++size;
		array.set(0, element);
		for( ; element.compareTo(array.get(hole/2)) < 0; hole /= 2) {
			T old = array.get(hole);
			array.set(hole, array.get(hole / 2));
			array.set(hole / 2, old);
		}
		array.set(hole, element);
		array.set(0, null);
	}
	
	/**
	 * Finds the minimum-priority element (e.g. the root)
	 * @return The minimum-priority element
	 */
	public T findMin() {
		if(this.size == 0) {
			return null;
		}
		else {
			return array.get(1);
		}
	}
	
	/**
	 * Deletes the minimum-priority element (e.g. the root), percolating down)
	 * @return The minimum-priority element
	 */
	public T deleteMin() {
		if(this.size == 0) {
			return null;
		}
		if(this.size == 1) {
			T min = array.get(1);
			array = new ArrayList<T>();
			array.add(null);
			this.size = 0;
			return min;
		}
		T minItem = this.findMin();
		array.set(1, array.get(this.size--));
		array.remove(this.size + 1);
		this.percolateDown(1);
		return minItem;
	}
	
	/**
	 * Performs a percolation-down, restoring the BinaryHeap to an acceptable state
	 * @param hole - The place from which an element was just removed
	 */
	private void percolateDown(int hole) {
		int child;
		T tmp = array.get(hole);
		
		for( ; hole * 2 <= this.size; hole = child) {
			child = hole * 2;
			if(child != this.size && array.get(child + 1).compareTo(array.get(child)) < 0) {
				child++;
			}
			if(array.get(child).compareTo(tmp) < 0) {
				array.set(hole, array.get(child));
			}
			else {
				break;
			}
		}
		array.set(hole, tmp);
	}
	
	/**
	 * Sorts an array of type T from least-priority to most-priority, using this BinaryHeap
	 * @param toSort - The array to sort
	 */
	public void sort(T[] toSort) {
		for(T item : toSort) {
			this.insert(item);
		}
		for(int i = 0; i < toSort.length; i++) {
			toSort[i] = this.deleteMin();
		}
	}
}