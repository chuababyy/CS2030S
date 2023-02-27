class ServiceBeginEvent extends Event {
  private Customer customer;
  private BankCounter bankCounter; 
  private Bank bank;
  private double endTime;
  private String customerTask;

  public ServiceBeginEvent(double arrivalTime, Customer customer, 
      BankCounter bankCounter, Bank bank) {
    super(arrivalTime);
    this.customer = customer;
    this.bankCounter = bankCounter;
    this.bank = bank;
    this.endTime = arrivalTime + customer.getServiceTime();
    this.customerTask = this.customer.getCustomerTaskString();
  }

  @Override 
  public String toString() {
    String str = String.format(": " + this.customer.toString() + "%s begin (by " + 
        this.bankCounter.toString() + ")", 
        customerTask);
    return super.toString() + str;
  }  

  // Mark the counter as unavailable, then 
  // schedule a service-end event at the end service time 
  @Override 
  public Event[] simulate() {
    this.bankCounter.makeUnAvailable();
    return new Event[] {
      new ServiceEndEvent(endTime, customer, bankCounter, bank)
    }; 
  }

}  
