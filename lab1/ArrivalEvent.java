class ArrivalEvent extends Event {

  private Customer customer; 
  private BankCounter bankCounter; 

  public ArrivalEvent(double arrivalTime, Customer customer, BankCounter bankCounter) {
    super(arrivalTime);
    this.customer = customer;
    this.bankCounter = bankCounter;
  } 
    
  @Override 
  public String toString() {
    String str = String.format(": Customer %d arrives", this.customer.getCustomerID());
    return super.toString() + str;
  }
  
  @Override 
  public Event[] simulate() {
    if (this.bankCounter.isAvailable() != -1) { // There is an available counter
      return new Event[] {
        new ServiceBeginEvent(this.getTime(), this.customer, this.bankCounter, bankCounter.isAvailable())
      };
    } else { // no counters are available
      return new Event[] {
        new DepartureEvent(this.getTime(), this.customer)
      };
    } 
  }
}  
