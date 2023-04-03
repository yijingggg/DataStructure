public interface CandyMachine {
    /**

     Displays the products available in the candy machine.
     */
    public void display();
    /**

     Processes the sale of the selected item, accepts the amount paid by the customer,
     calculates and gives the change, and dispenses the item using the appropriate dispenser.
     @param selection The selection made by the customer (e.g. "A1", "B2", etc.).
     @param amount The amount paid by the customer.
     @throws IllegalArgumentException if selection is invalid or amount is less than the price of the selected item.
     */
    public void makeSale(String selection, double amount);
}
