public interface Dispenser {

    /**

     Returns the name of the product in the dispenser.
     @return The name of the product in the dispenser.
     */
    public String getName();
    /**

     Returns the current quantity of item in the dispenser.
     @return The current quantity of item in the dispenser.
     */
    public int getQuantity();
    /**

     Returns the price of the product in the dispenser.
     @return The price of the product in the dispenser.
     */
    public double getPrice();
    /**

     Returns true if the dispenser is empty, false otherwise.
     @return True if the dispenser is empty, false otherwise.
     */
    public boolean isEmpty();
    /**

     Dispenses one item from the dispenser and reduces the quantity by 1.
     @throws RuntimeException if the dispenser is empty.
     */
    public void dispense();
}
