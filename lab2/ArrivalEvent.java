class ArrivalEvent extends Event {

  private Customer customer;
  private Bank bank;

  public ArrivalEvent(double arrivalTime, Customer customer, Bank bank) {
    super(arrivalTime);
    this.customer = customer;
    this.bank = bank;
  }

  @Override
  public String toString() {
    String str = String.format(": " + this.customer.toString() + "arrived " + this.bank.toString());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    int availCounterNum = this.bank.hasAvailCounter();
    
    if (availCounterNum != -1) { // There is an available counter
      return new Event[] {
        new ServiceBeginEvent(this.getTime(), this.customer, bank, availCounterNum)
      }; 
    } else { // no counters are available
      if (this.bank.getQueue().isFull()) { // Queue is full, customer departs
        return new Event[] {
          new DepartureEvent(this.getTime(), this.customer)
        }; 
      } else { // queue is not full, customer joins queue
        return new Event[] {
          new JoinQueueEvent(this.getTime(), this.customer, this.bank)
        };
      }
    }
  }
}
