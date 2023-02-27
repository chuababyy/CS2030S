class ServiceEndEvent extends Event {
  
  private Customer customer;
  private BankCounter bankCounter;
  private Bank bank;
  private String customerTask;
  
  public ServiceEndEvent(double endTime, Customer customer, BankCounter bankCounter, Bank bank) {
    super(endTime);
    this.customer = customer;
    this.bankCounter = bankCounter;
    this.bank = bank;
    this.customerTask = this.customer.getCustomerTaskString();
  }  

  @Override
  public String toString() {
    String str = String.format(": " + this.customer.toString() + "%s done (by " + 
        this.bankCounter.toString() + ")",
        this.customerTask);
    return super.toString() + str;
  }  

  @Override
  public Event[] simulate() {
    if (this.bankCounter.isCounterQueueEmpty()) { // Counter Q empty, check entrance Q
      if (this.bank.isEntranceQueueEmpty()) { // Both Q is empty, cust departs 
        this.bankCounter.makeAvailable(); 
        return new Event[] {
          new DepartureEvent(this.getTime(), this.customer)
        };
      } else { // entrance has Q, curr cust depart, next cust Serv Begin
        Customer nextCust = this.bank.deqEntranceQueue();
        return new Event[] {
          new DepartureEvent(this.getTime(), this.customer),
          new ServiceBeginEvent(this.getTime(), nextCust, this.bankCounter, this.bank)
        };
      }
    } else { // Counter Q not empty, check entrance queue
      if (this.bank.isEntranceQueueEmpty()) { // if ent Q empty, 
        Customer newCustomer = this.bankCounter.deqCounterQueue();
        return new Event[] {
          new DepartureEvent(this.getTime(), this.customer),
          new ServiceBeginEvent(this.getTime(), newCustomer, this.bankCounter, this.bank)
        };
      } else { // curr cust depart, 1st cust in Counter Q SB, first in ent Q join counter Q
        Customer nextCust = this.bankCounter.deqCounterQueue();
        Customer newJoinQCustomer = this.bank.deqEntranceQueue();
        return new Event[] {
          new DepartureEvent(this.getTime(), this.customer),
          new ServiceBeginEvent(this.getTime(), nextCust, this.bankCounter, this.bank),
          new JoinCounterQueueEvent(this.getTime(), newJoinQCustomer, this.bankCounter)
        };
      }
    }
  }
}  
