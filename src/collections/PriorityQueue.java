package collections;

/**
 * An interface that represents the needed methods for a 
 * Priority Queue. A Priority Queue is a queue where
 * the item at the front is the item with the highest priority.
 * 
 * @author Karissa McKelvey, krmckelv@indiana.edu
 * @author Frank Mackey, fmackey@indiana.edu
 * @author Phil Pitzer, ppitzer@indiana.edu
 * 
 * @param <T> The Element Type
 */
public interface PriorityQueue<T>
{
/** Adds an item to the priority queue
 * @param item
 */
	public void insert(T item); 
  
/**Removes the item at the front of the queue and returns it
 * @return item at the front of the queue
 */
public T removeFront(); 
/** Returns, but does not remove, the item at the front of the queue
 * @return item at the front of the queue
 */
public T peek();  

/** Returns the number of items in the queue
 * @return the number of items in the queue
 */
public int getSize(); // 
}