class DepartureEvent extends Event {
  private Customer customer;

  public DepartureEvent(double time, Customer customer) {
    super(time);
    this.customer = customer;
  }
  
  @Override
  public String toString() {
    String str = String.format(": " + this.customer.toString() + "departed");
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    return new Event[] {}; 
  } 
}  
