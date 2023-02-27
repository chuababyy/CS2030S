class ServiceEndEvent extends Event {
  
  private Customer customer;
  private Bank bank;
  private int servingCounter;
  private String customerTask;

  public ServiceEndEvent(double endTime, Customer customer, Bank bank, int servingCounter) {
    super(endTime);
    this.customer = customer;
    this.bank = bank;
    this.servingCounter = servingCounter;
    this.customerTask = this.customer.getCustomerTaskString();
  }  

  @Override
  public String toString() {
    String str = String.format(": " + this.customer.toString() + "%s done (by S" + "%d)",
          this.customerTask, this.servingCounter);
    return super.toString() + str;
  }  

  // If queue is empty:
  // Mark the counter as available, then schedule
  // departure event at the current time.
  // If queue is not empty:
  // Existing customer will depart,
  // dequeue the first customer and create new servicBegin
  @Override
  public Event[] simulate() {
    if (this.bank.getQueue().isEmpty()) {
      this.bank.makeAvailable(servingCounter); 
      return new Event[] {
        new DepartureEvent(this.getTime(), this.customer)
      };
    } else {
      Customer newCustomer = (Customer) this.bank.getQueue().deq();
      return new Event[] {
        new DepartureEvent(this.getTime(), this.customer),
        new ServiceBeginEvent(this.getTime(), newCustomer, bank, servingCounter) 
      };  
    }  
  }  
}  
