class ServiceEndEvent extends Event {
  
  private Customer customer;
  private BankCounter bankCounter;
  private int servingCounter;

  public ServiceEndEvent(double endTime, Customer customer, BankCounter bankCounter, int servingCounter) {
    super(endTime);
    this.customer = customer;
    this.bankCounter = bankCounter;
    this.servingCounter = servingCounter;
  }  

  public String toString() {
    String str = String.format(": Customer %d service done (by Counter %d)",
          this.customer.getCustomerID(), this.servingCounter);
     return super.toString() + str;
  }  

  // Mark the counter is available, then schedule
  // a departure event at the current time.
  public Event[] simulate() {
    bankCounter.makeAvailable(this.servingCounter);
    return new Event[] {
      new DepartureEvent(this.getTime(), this.customer)
    };
  }  
}  
