// This class encapsulates a customer joining an entrance queue event

class JoinQueueEvent extends Event {

  private Customer customer;
  private Bank bank; 

  public JoinQueueEvent(double arrivalTime, Customer customer, Bank bank) {
    super(arrivalTime);
    this.customer = customer;
    this.bank = bank; 
  }  
  
  @Override
  public String toString() {
    String str = String.format(": " + this.customer.toString() + 
        "joined bank queue " + this.bank.toString());
    return super.toString() + str;
  }  
  
  // enqueue customer and then return an empty Event
  @Override
  public Event[] simulate() {
    this.bank.enqEntranceQueue(customer);
    return new Event[] {};
  }
}  
