package HW7;


/**
 * A collection of objects that are inserted and removed according to the last-in
 * first-out principle. Although similar in purpose, this interface differs from
 * java.util.Stack.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

public interface Queue<E> {
/** Returns the number of elements in the queue*/
    int size();

/** Tests whether the queue is empty */
    boolean isEmpty();

/** Inserts an element at the rear of the queue */
    void enqueue(E e);

/** Returns, but does not remove the first element of the queue (null if empty) */
    E first();

/** Removed and returns the first element of the queue (null if empty) */
    E dequeue();

}
