/**
 * Wilson Lin
 * 115091711
 * wilson.lin.2@stonybrook.edu
 * Hw 3
 * CSE214.R04 Summer 2024
 */

/**
 * The <code>BooleanSource</code> class is used to get a random probability
 * of an event to happen. Referenced from the slides.
 */
public class BooleanSource {
    private double probability;

    /**
     * Parameterized constructor for creating a boolean source.
     * @param probability
     * The probability of the request.
     * @throws IllegalArgumentException
     * Indicates that probability must be between 0 and 1.
     */
    public BooleanSource(double probability) throws IllegalArgumentException {
        if (probability < 0.0 || probability > 1.0) {
            throw new IllegalArgumentException("Probability must be between 0 and 1.");
        }
        this.probability = probability;
    }

    /**
     * A method to determine if a request arrives.
     * @return
     * Returns true if the request arrives otherwise it returns false.
     */
    public boolean requestArrived() {
        return (Math.random() < probability);
    }

    /**
     * Gets the probability of a request.
     * @return
     * Returns the probability of a request.
     */
    public double getProbability() {
        return probability;
    }

    /**
     * Sets the probability of a request.
     * @param probability
     * The probability to set for the request.
     */
    public void setProbability(double probability) {
        this.probability = probability;
    }
}
