public interface CashRegister {

    /**

     Adds the amount to the cash on hand of the cash register.
     @param amount The amount to add to the cash on hand.
     @return The new amount of cash on hand.
     @throws IllegalArgumentException if amount is negative.
     */
    public double acceptPayment(double amount);
    /**

     Calculates and returns the change to be given to the customer, updates the amount of cash on hand accordingly.
     @param amount The amount paid by the customer.
     @return The change to be given to the customer.
     @throws IllegalArgumentException if amount is less than the total cost of the items sold.
     */
    public double giveChange(double amount);
    /**

     Returns the current amount of cash on hand in the cash register.
     @return The current amount of cash on hand in the cash register.
     */
    public double getCashOnHand();
}
