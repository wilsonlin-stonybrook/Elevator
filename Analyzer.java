import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The <code>Analyzer</code> class will be used to take user inputs and
 * simulate the simulator class.
 */
public class Analyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Elevator simulator!");
        while (true) {
            try {
                System.out.println("Please enter the probability of arrival for Request: ");
                double probability = input.nextDouble();
                System.out.println("Please enter the number of floors: ");
                int floors = input.nextInt();
                System.out.println("Please enter the number of elevators: ");
                int elevators = input.nextInt();
                System.out.println("Please enter the length of the simulation (in time units): ");
                int length = input.nextInt();
                Simulator.simulate(probability, floors, elevators, length);
                System.out.println();
                System.out.println("Simulation is over!");
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid value.");
                input.next();
            }
        }
        input.close();
    }
}
