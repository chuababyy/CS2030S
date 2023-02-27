class JoinCounterQueueEvent extends Event {
  
  private Customer customer;
  private BankCounter bankCounter;

  public JoinCounterQueueEvent(double arrivalTime, Customer customer, BankCounter bankCounter) {
    super(arrivalTime);
    this.customer = customer;
    this.bankCounter = bankCounter;
  }

  @Override
  public String toString() {
    String str = String.format(": " + this.customer.toString() + "joined counter queue "
        + "(at " + this.bankCounter.toString() + ")");
    return super.toString() + str;
  }
  
  // enqueue the customer in the counter queue and truen empty Event
  @Override 
  public Event[] simulate() { 
    this.bankCounter.enqCounterQueue(customer);
    return new Event[] {};
  }
}
