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
    BankCounter availCounter = this.bank.isAvailCounter();
    BankCounter shortestCounterQueue = this.bank.getShortestCounterQueue();

    if (availCounter != null) { // There is an available counter
      return new Event[] {
        new ServiceBeginEvent(this.getTime(), this.customer, availCounter, this.bank)
      }; 
    } else { // no counters are available
      if (shortestCounterQueue == null) { // all counter queues are full, check entrance queue 
        if (this.bank.isEntranceQueueFull()) { // entrance queue is full, customer departs
          return new Event[] {
            new DepartureEvent(this.getTime(), this.customer)
          }; 
        } else { // entrance queue is not full, customer joins queue
          return new Event[] {
            new JoinQueueEvent(this.getTime(), this.customer, this.bank)
          };
        }
      } else { // there is a counter queue that has space
        return new Event[] {
          new JoinCounterQueueEvent(this.getTime(), this.customer, shortestCounterQueue)
        };
      }
    }
  }
}
