class ServiceBeginEvent extends Event {
  private Customer customer;
  private Bank bank; 
  private double endTime;
  private int servingCounter;
  private String customerTask;

  public ServiceBeginEvent(double arrivalTime, Customer customer, Bank bank, int servingCounter) {
    super(arrivalTime);
    this.customer = customer;
    this.bank = bank;
    this.endTime = arrivalTime + customer.getServiceTime();
    this.servingCounter = servingCounter;
    this.customerTask = this.customer.getCustomerTaskString();
  }



  @Override 
  public String toString() {
    String str = String.format(": " + this.customer.toString() + "%s begin (by S" + "%d)",
          customerTask, servingCounter);
    return super.toString() + str;
  }  

  // Mark the counter as unavailable, then 
  // schedule a service-end event at the end service time 
  @Override 
  public Event[] simulate() {
    this.bank.makeUnAvailable(servingCounter);
    return new Event[] {
      new ServiceEndEvent(endTime, customer, bank, servingCounter)
    }; 
  }

}  
