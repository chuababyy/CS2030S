class BankCounter {
  
  /**
   * A value to  indicate if a service counter is
   * available.  available is true if and only
   * if service counter is available to serve.
   */
  private  boolean isAvailable;

  /**
   * The id of the counter associated with this event.
   * This field only matters if the event type if
   * SERVICE_BEGIN or SERVICE_END.
   */
  private  int counterID;

  private static int counterIndex = 0;

  public BankCounter() {
    this.isAvailable = true;
    this.counterID = BankCounter.counterIndex;
    BankCounter.counterIndex++;
  }

  // returns availability of current BankCounter
  public boolean getAvailable() {
    return this.isAvailable;
  }

  // Marks this counter as unavailable 
  public void makeUnAvailable() {
    this.isAvailable = false;
  }

  //Marks this counter as available
  public void makeAvailable() {
    this.isAvailable = true;
  }

  // Calculates when the counter will be free again at
  public double endTime(double arrivalTime, double serviceTime) {
    return arrivalTime + serviceTime;
  }
}

