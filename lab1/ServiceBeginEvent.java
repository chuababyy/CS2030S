class ServiceBeginEvent extends Event {
  private Customer customer;
  private BankCounter bankCounter; 
  private double endTime;
  private int servingCounter; 

  public ServiceBeginEvent(double arrivalTime, Customer customer, BankCounter bankCounter, int servingCounter) {
    super(arrivalTime);
    this.customer = customer;
    this.bankCounter = bankCounter;
    this.endTime = arrivalTime + customer.getServiceTime();
    this.servingCounter = servingCounter; 
  }

  @Override 
  public String toString() {
    String str = String.format(": Customer %d service begin (by Counter %d)",
          this.customer.getCustomerID(), servingCounter);
    return super.toString() + str;
  }  

  // Mark the counter as unavailable, then 
  // schedule a service-end event at the end service time 
  @Override 
  public Event[] simulate() {
    bankCounter.makeUnAvailable(servingCounter);
    return new Event[] {
      new ServiceEndEvent(endTime, customer, bankCounter, servingCounter)
    }; 
  }

}  
