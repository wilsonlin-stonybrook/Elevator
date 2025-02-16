
import java.util.LinkedList;

/**
 * The <code>Simulator</code> class will be used to carry out the simulation.
 */
public class Simulator {
    /**
     * Simulates the elevator and prints the results of the simulation.
     * @param probability
     * The probability of the request during each time.
     * @param floors
     * The number of floors in the building.
     * @param elevators
     * The number of elevators in the building.
     * @param simulation
     * The length of the simulation.
     * @throws IllegalArgumentException
     * Indicates that the input parameters are incorrect.
     */
    public static void simulate(double probability, int floors, int elevators, int simulation) {
        if (probability < 0.0 || probability > 1.0) {
            throw new IllegalArgumentException("Probability must be between 0 and 1.");
        }
        if (floors <= 1) {
            throw new IllegalArgumentException("Number of floors must be greater than 1.");
        }
        if (elevators <= 0) {
            throw new IllegalArgumentException("Number of elevators must be greater than 0.");
        }
        if (simulation <= 0) {
            throw new IllegalArgumentException("Simulation length must be greater than 0.");
        }
        BooleanSource booleanSource = new BooleanSource(probability);
        RequestQueue requestQueue = new RequestQueue();
        LinkedList<Elevator> elevatorList = new LinkedList<>();
        for (int i = 0; i < elevators; i++) {
            elevatorList.add(new Elevator());
        }
        int totalWaitTime = 0;
        int totalRequests = 0;
        for (int time = 0; time < simulation; time++) {
//             System.out.println("Step " + (time + 1) + ":");
            if (booleanSource.requestArrived()) {
                Request request = new Request(floors);
                request.setTimeEntered(time);
                requestQueue.enqueue(request);
//                System.out.println("A request arrives from Floor " + request.getSourceFloor()
//                        + " to Floor " + request.getDestinationFloor());
//            }
//             else {
//                System.out.println("Nothing arrives");
                for (int i = 0; i < elevatorList.size(); i++) {
                    Elevator elevator = elevatorList.get(i);
                    switch (elevator.getElevatorState()) {
                        case (Elevator.IDLE):
                            if (!requestQueue.isEmpty()) {
                                Request request1 = requestQueue.dequeue();
                                elevator.setRequest(request1);
                                elevator.setElevatorState(Elevator.TO_SOURCE);
                            }
                            break;
                        case Elevator.TO_DESTINATION:
                            if (elevator.getCurrentFloor() < elevator.getRequest().getDestinationFloor()) {
                                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
                            } else if (elevator.getCurrentFloor() > elevator.getRequest().getDestinationFloor()) {
                                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
                            } else {
                                elevator.setElevatorState(Elevator.IDLE);
                                elevator.setRequest(null);
                            }
                            break;
                        case Elevator.TO_SOURCE:
                            if (elevator.getCurrentFloor() < elevator.getRequest().getSourceFloor()) {
                                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
                            } else if (elevator.getCurrentFloor() > elevator.getRequest().getSourceFloor()) {
                                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
                            } else {
                                elevator.setElevatorState(Elevator.TO_DESTINATION);
                                int timeElapsed = (time - elevator.getRequest().getTimeEntered());
                                totalWaitTime += timeElapsed;
                                totalRequests++;
                                System.out.println("Total Wait Time = " + totalWaitTime
                                        + ", Total Requests = " + totalRequests);
                            }
                            break;
                    }
                }
            }
//            System.out.println("Requests: ");
//            for (int i = 0; i < requestQueue.size(); i++) {
//                Request request = requestQueue.get(i);
//                System.out.println("(" + request.getSourceFloor() + ", " + request.getDestinationFloor()
//                        + ", " + request.getTimeEntered() + ") ");
//            }
//            System.out.println();
//            System.out.println("Elevators: ");
//            for (int i = 0; i < elevatorList.size(); i++) {
//                Elevator elevator = elevatorList.get(i);
//                String state;
//                if (elevator.getElevatorState() == Elevator.IDLE) {
//                    state = "IDLE";
//                } else if (elevator.getElevatorState() == Elevator.TO_SOURCE) {
//                    state = "TO_SOURCE";
//                } else {
//                    state = "TO_DESTINATION";
//                }
//                String request;
//                if (elevator.getRequest() == null) {
//                    request = "---";
//                } else {
//                    request = ("(" + elevator.getRequest().getSourceFloor() + ", "
//                    + elevator.getRequest().getDestinationFloor() + ", " + elevator.getRequest().getTimeEntered() + ")");
//                }
//                System.out.println("[Floor " + elevator.getCurrentFloor() + ", "
//                + state + ", " + request + "] ");
//            }
//            System.out.println();
        }
        double averageWaitTime;
        if (totalRequests == 0) {
            averageWaitTime = 0;
        }
        else {
            averageWaitTime = (double) totalWaitTime / totalRequests;
        }
        System.out.println();
        System.out.println("Total Wait Time = " + totalWaitTime);
        System.out.println("Total Requests = " + totalRequests);
        System.out.printf("%-20s%.02f", "Average Wait Time = ", averageWaitTime);
    }
}
