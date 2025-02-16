/**
 * Wilson Lin
 * 115091711
 * wilson.lin.2@stonybrook.edu
 * Hw 3
 * CSE214.R04 Summer 2024
 */

import java.util.LinkedList;

/**
 * The <code>RequestQueue</code> class extends a linked list and
 * is used for the creation of a queue to hold the requests.
 */
public class RequestQueue extends LinkedList<Request> {

    /**
     * Constructor that creates an empty request queue.
     */
    public RequestQueue() {
        super();
    }

    /**
     * A method that enqueues a request to the end of the queue.
     * @param request
     * The request that is going to be inserted into the queue.
     */
    public void enqueue(Request request) {
        this.addLast(request);
    }

    /**
     * A method to dequeue a request from the queue.
     * @return
     * Returns null if the queue is empty, or it returns the request that is dequeued.
     */
    public Request dequeue() throws IllegalArgumentException {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        else {
            return super.removeFirst();
        }
    }

    /**
     * A method to get the size of the queue.
     * @return
     * Returns the size of the queue.
     */
    public int size() {
        return super.size();
    }

    /**
     * A method to check if the queue is empty.
     * @return
     * Returns true if the queue is empty otherwise it will return false.
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
