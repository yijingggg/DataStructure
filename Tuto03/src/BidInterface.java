public interface BidInterface {

    /**return name of the company making this bid
     *
     * @return name of the company making this bid
     */
    public String getCompanyName();

    /**return the description of the air conditioner that this bid is for
     *
     * @return the description of the air conditioner that this bid is for
     */
    public String getDescription();

    /**return the capacity of this bid's AC in tons
     *
     * @return the capacity of this bid's AC in tons
     */
    public double getCapacity();

    /**return seasonal efficiency of this bid's AC(SEER)
     *
     * @return seasonal efficiency of this bid's AC(SEER)
     */
    public double getACSEER();

    /**returns the cost of this bid's AC.
     *
     * @return the cost of this bid's AC.
     */
    public double getACCost();

    /**returns the cost of installing this bid's AC.
     *
     * @return the cost of installing this bid's AC.
     */
    public double getACInstallCost();

    /**returns the yearly cost of operating this bid's AC
     *
     * @return the yearly cost of operating this bid's AC
     */
    public double getACYearlyCost();
}

