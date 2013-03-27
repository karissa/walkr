package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
  * Our representation a Priority Queue implemented as a Binary Heap.
 * 
 * @author Karissa McKelvey, krmckelv@indiana.edu
 * @author Frank Mackey, fmackey@indiana.edu
 * @author Phil Pitzer, ppitzer@indiana.edu
 * 
 * @param <T> The Element Type
 */
public class BinaryHeap<T> implements PriorityQueue<T> {

	private ArrayList<T> heap = new ArrayList<T>();
	private Comparator<T> comparator;
	
	
	/** Creates an empty Binary Heap from the given comparator
	 * @param comparator
	 */
	public BinaryHeap(Comparator<T> comparator){
		this.comparator = comparator;
		heap.add(null);
	}
	
	/** Populates a binary heap given a comparator
	 * and a list of items
	 * @param comparator 
	 * @param items
	 */
	public BinaryHeap(Comparator<T> comparator, ArrayList<T> items){
		this(comparator);
		while(!items.isEmpty()) {
			insert(items.remove(items.size() -1));
		}
	}
	
	/* (non-Javadoc)
	 * @see collections.PriorityQueue#insert(java.lang.Object)
	 */
	@Override
	public void insert(T item) {
		heap.add(item);
		bubble(heap.size() - 1);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return heap.toString();
	}
	
	/* (non-Javadoc)
	 * @see collections.PriorityQueue#removeFront()
	 */
	@Override
	public T removeFront() {
		T temp = null;
		if(heap.size() > 1) {
			temp = heap.remove(1);
			rebuild();
		}
		return temp;
	}
	/* (non-Javadoc)
	 * @see collections.PriorityQueue#peek()
	 */
	@Override
	public T peek() {
		if(heap.size() > 1)
			return heap.get(1);
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see collections.PriorityQueue#getSize()
	 */
	@Override
	public int getSize() {
		return heap.size();		
	}

	/** Bubbles 'up' on given index in order to maintain
	 * the binary heap's basic properties
	 * @param index
	 */
	private void bubble(int index) {
		T bubblin = heap.get(index); 
		T bubblinParent = getParent(index);
		if(bubblinParent != null && (comparator.compare(bubblin,bubblinParent) < 0)){
			Collections.swap(heap, index, (index / 2));
			bubble(index / 2);
		}
	}
	
	/**
	 * Rebuilds the binary heap by trickling down 
	 * (also called bubbling down) by moving the first leaf 
	 * node to the front of the heap and calling 
	 * trickleDown() on that index
	 */
	private void rebuild() {
		int trickling = heap.size() - 1;
		if(heap.size() > 1){
			heap.add(1, heap.remove(trickling));
			trickleDown(1);
		}
	}
	
	/** Takes an index and finds the minimum between
	 * that item and its two children; then grabs
	 * the minimum and swaps it with the given index.
	 * Recursively does this for the rest of the list
	 * until the minimum is item at the given index.
	 * @param index
	 */
	private void trickleDown(int index){
		int min = minOfThree(index);
		if (min != index) {
			Collections.swap(heap,index,min); //if the min isn't the index, swap them
			trickleDown(min);
		}
	}
	
	/** Takes an index and grabs the two children of that
	 * index as well as the item at that index and
	 * compares them, returning the index of the minimum 
	 * value.
	 * @param index
	 * @return index of the minimum value
	 */
	private int minOfThree(int index) {
		T temp = heap.get(index);
		T lchild = getLeftChild(index);
		T rchild = getRightChild(index);
		
		int min = index;
		if(lchild == null && rchild == null) {
			return min;
		}else {  // check if left or right child is null then just compare two things
			if (rchild == null) {
				if(comparator.compare(temp,lchild) > 0) { //left child is smaller than temp
					min = (index * 2); 
				}
			}else if (lchild == null) {
				if (comparator.compare(temp, rchild) > 0) {
					min = (index * 2) + 1;
				}
			}else if(comparator.compare(temp,lchild) > 0) { //left child is smaller than temp
				if(comparator.compare(lchild,rchild) > 0) 
					min = (index * 2) + 1; //right child is smaller than left child
				else
					min = (index * 2); //left child is smaller than right child
			}
			else {
				if(comparator.compare(temp, rchild) > 0)  //temp is smaller than left child
					min = (index *2) + 1; //right child is bigger than temp
		
			}
		}
			return min;
	}

	
	/** Returns the left child of a given index.
	 * @param index
	 * @return left child
	 */
	private T getLeftChild(int index){
		int leftchild = index * 2;
		if (heap.size() <= leftchild)
			return null;  // The left child doesn't exist
		else {
			return heap.get(leftchild);
		}
	}
	
	/** Returns the right child of a given index.
	 * @param index
	 * @return
	 */
	private T getRightChild(int index){
		int rightchild = (index * 2) + 1;
		if (heap.size() <= rightchild)
			return null;  // The right child doesn't exist
		else {
			return heap.get(rightchild);
		}
	}
	
	/** Returns the parent of a given index.
	 * @param index
	 * @return
	 */
	private T getParent(int index){
		int parent = index / 2;
		if (heap.size() < parent)
			return null;  // The index is the root or incorrect index
		else {
			return heap.get(parent);
		}
	}
	
	/** Sorts the items in the given list
	 * according to the given comparator. It uses
	 * a binary heap to sort the list and then converts
	 * it to an ArrayList, which it returns.
	 * @param <T> the item type
	 * @param comparator by which the items will be sorted
	 * @param items list of items to sort
	 * @return a new ArrayList of the given items in sorted order.
	 */
	public static <T> ArrayList<T> heapsort(Comparator<T> comparator, ArrayList<T> items){
		System.out.println("Heapsorting " + items.size() + " items");
		BinaryHeap<T> temp = new BinaryHeap<T>(comparator, items);
		ArrayList<T> sorted = new ArrayList<T>();
		while (temp.peek() != null){
			sorted.add(temp.removeFront());
		}
		return sorted;
	}

}
