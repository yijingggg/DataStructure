public interface BidCollectionInterface {

    /**
     * Adds a bid to this collection.
     *
     * @param newBit the bid to add to this collection
     */
    public void addBit(BidInterface newBit);

    /**
     * Returns the bid in this collection with the best yearly cost.
     *
     * @return the bid in this collection with the best yearly cost.
     * @throws java.util.NoSuchElementException if this collection is empty
     */
    public BidInterface getBestYearlyCost();

    /**
     * Returns the bid in this collection with the best initial cost. The initial cost
     * will be defined as the unit cost plus the installation cost.
     *
     * @return the bid in this collection with the best initial cost.
     * @throws java.util.NoSuchElementException if this collection is empty
     */
    public BidInterface getBestInitialCost();


    /**
     * Clears all the items from this collection.
     */
    public void clearBid();

    /**
     * Gets the number of items in this collection.
     *
     * @return the number of items in this collection.
     */
    public int getNumberOfBid();

    /**
     * Sees whether this collection is empty
     *
     * @return true if this collection is empty, false otherwise
     */
    public boolean isEmpty();


    /**
     * Searches for bids whose yearly cost is less than or equal to the specified maximum cost.
     *
     * @param maxCost The maximum yearly cost.
     * @return An array of bids whose yearly cost is less than or equal to the specified maximum cost,
     * or an empty array if no such bids are found.
     * @throws IllegalArgumentException If maxCost is negative.
     */
    public BidInterface[] searchByYearlyCost(double maxCost);

    /**
     * Searches for bids whose seasonal efficiency is greater than or equal to the specified minimum SEER.
     *
     * @param minSEER The minimum seasonal efficiency (SEER).
     * @return An array of bids whose seasonal efficiency is greater than or equal to the specified minimum SEER,
     * or an empty array if no such bids are found.
     * @throws IllegalArgumentException If minSEER is negative.
     */
    public BidInterface[] searchBySEER(double minSEER);

}