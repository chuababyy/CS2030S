// This class models a customer entering the bank

class Customer {

  /**
   * The id of a customer associated with this event.
   * First customer has id 0. Next is 1, 2, etc.
   */
  private int customerID;

  /**
   * The service time of the customer associated
   * this event.  This field matters only if the
   * event type is ARRIVAL or SERVICE_BEGIN.
   */
  private double serviceTime;

  /**
   * Keeps track of the total number of customers.
   * Starts from 1, 2, etc. 
   */
  private static int customerIndex = 0;

  public Customer(double serviceTime) {
    this.customerID = customerIndex;
    Customer.customerIndex++;
    this.serviceTime = serviceTime; 
  }

  public double getServiceTime() {
    return this.serviceTime;
  }  

  public int getCustomerID() {
    return this.customerID;
  }

}
