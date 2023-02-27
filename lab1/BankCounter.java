class BankCounter {
  
  /**
   * An array to indicate if a service counter is
   * available.  available[i] is true if and only
   * if service counter i is available to serve.
   */
  private  boolean[] available;

  /**
   * The id of the counter associated with this event.
   * This field only matters if the event type if
   * SERVICE_BEGIN or SERVICE_END.
   */
   private  int counterID;

  /**
   * Keeps track of the total number of counters
   */
  private static int counterIndex = 0;

  public BankCounter(int numOfCounters) {
    this.available = new boolean [numOfCounters];
    for (int i = 0; i < numOfCounters; i++) {
      available[i] = true;
    }  
    this.counterID = BankCounter.counterIndex; 
    this.counterIndex++;
  }
  
  // Returns value of counter which is available.
  // If there is no counter available, returns -1. 
  public int isAvailable() {
    int counter = -1; 
    for (int i = 0; i < this.available.length; i++) {
      if (this.available[i]) {
        counter = i;
        break; 
      }
    }
    return counter; 
  }
  
  // Marks that counter as unavailable 
  public void makeUnAvailable(int counterNum) {
    this.available[counterNum] = false; 
  }

  public void makeAvailable(int counterNum) {
    this.available[counterNum] = true; 
  }  
    
  // Calculates when the counter will be free again at
  public double endTime(double arrivalTime, double serviceTime) {
    return arrivalTime + serviceTime;
  }

}  
