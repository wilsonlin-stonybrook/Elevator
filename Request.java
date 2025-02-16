/**
 * Wilson Lin
 * 115091711
 * wilson.lin.2@stonybrook.edu
 * Hw 3
 * CSE214.R04 Summer 2024
 */

/**
 * The <code>Request</code> class is used for the creation of a request object.
 */
public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;

    /**
     * Parameterized constructor for creating a request object with
     * specific number of floors.
     * @param numberFloors
     * The number of floors.
     */
    public Request(int numberFloors) {
        this.sourceFloor = (int) (Math.random() * numberFloors) + 1;
        this.destinationFloor = (int) (Math.random() * numberFloors) + 1;
        this.timeEntered = -1;
        while (this.sourceFloor == this.destinationFloor) {
            this.destinationFloor = (int) (Math.random() * numberFloors) + 1;
        }
    }

    /**
     * Gets the source floor of the request.
     * @return
     * Returns the source floor of the request.
     */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * Sets the source floor of the equest.
     * @param sourceFloor
     * The source floor of the request.
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    /**
     * Gets the destination floor of the request.
     * @return
     * Returns the destination floor of the request.
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * Sets the destination floor of the request.
     * @param destinationFloor
     * The destination floor of the request.
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    /**
     * Gets the time entered of the request.
     * @return
     * Returns the time entered of the request.
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * Sets the time entered of the request.
     * @param timeEntered
     * The time entered of the request.
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
}
