public interface RideInterface {
    /**
     * Add visitors to the queue
     *
     * @param visitor
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Remove visitors from the queue
     *
     * @param visitor
     */
    void removeVisitorFromQueue(Visitor visitor);

    /**
     * Print visitors in the queue
     */
    void printQueue();

    /**
     * Perform a cycle of the ride
     */
    void runOneCycle();

    /**
     * Add visitors to history
     *
     * @param visitor
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Check if the visitor is in the history
     *
     * @param visitor
     * @return
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Return the number of visitors in the historical record
     *
     * @return
     */
    int numberOfVisitors();

    /**
     * Print visitors in the ride history
     */
    void printRideHistory();
}
