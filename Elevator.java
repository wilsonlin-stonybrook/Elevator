
/**
 * The <code>Elevator</code> class is used for the creation of an elevator
 * object, and it will take request from the request queue.
 */
public class Elevator {
    public static final int IDLE = 0;
    public static final int TO_SOURCE = 1;
    public static final int TO_DESTINATION = 2;
    private int currentFloor;
    private int elevatorState;
    private Request request;

    /**
     * Default constructor to create an elevator object, and it sets
     * request to null, the elevator state to idle, and current floor to 1.
     */
    public Elevator() {
        this.request = null;
        this.elevatorState = IDLE;
        this.currentFloor = 1;
    }

    /**
     * Gets the current floor of the elevator.
     * @return
     * Returns the current floor of the elevator.
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Sets the current floor of the elevator.
     * @param currentFloor
     * The current floor to set for the elevator.
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     * Gets the state of the elevator.
     * @return
     * Returns the state of the elevator.
     */
    public int getElevatorState() {
        return elevatorState;
    }

    /**
     * Sets the state of the elevator.
     * @param elevatorState
     * The state of the elevator to set.
     */
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    /**
     * Gets the request for the elevator.
     * @return
     * Returns the request of the elevator.
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Sets the request of the elevator.
     * @param request
     * The request of the elevator to set.
     */
    public void setRequest(Request request) {
        this.request = request;
    }
}
