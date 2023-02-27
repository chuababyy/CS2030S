class DepartureEvent extends Event {
  private Customer customer;

  public DepartureEvent(double time, Customer customer) {
    super(time);
    this.customer = customer;
  }
  
  @Override
  public String toString() {
    String str = String.format(": Customer %d departed", this.customer.getCustomerID());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    return new Event[] {}; 
  } 
}  
