class BankCounter implements Comparable<BankCounter> {
  
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

  private Queue<Customer> counterQueue;

  public BankCounter(int queueSize) {
    this.isAvailable = true;
    this.counterID = BankCounter.counterIndex;
    BankCounter.counterIndex++;
    this.counterQueue = new Queue<Customer>(queueSize);
  }

  // returns availability of current BankCounter
  public boolean getAvailable() {
    return this.isAvailable;
  }

  // Marks this counter as unavailable 
  public void makeUnAvailable() {
    this.isAvailable = false;
  }

  // Marks this counter as available
  public void makeAvailable() {
    this.isAvailable = true;
  }
  
  // Reimplementing Queue methods for counter queue
  public boolean enqCounterQueue(Customer c) {
    return this.counterQueue.enq(c);
  }
  
  public Customer deqCounterQueue() {
    return this.counterQueue.deq();
  }

  public boolean isCounterQueueFull() {
    return this.counterQueue.isFull();
  }

  public boolean isCounterQueueEmpty() {
    return this.counterQueue.isEmpty();
  }

  @Override 
  public int compareTo(BankCounter c) {
    if (this.counterQueue.length() < c.counterQueue.length()) {
      return -1;
    } else if (this.counterQueue.length() > c.counterQueue.length()) {
      return 1;
    } else {
      if (this.counterID < c.counterID) {
        return -1;
      } else {
        return 1;
      }
    }
  }

  @Override
  public String toString() {
    return String.format("S%d %s", this.counterID, this.counterQueue.toString());
  }
}

