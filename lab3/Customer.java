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
   */
  private static int customerIndex = 0;                                
    
  private final int customerTask; 
    
  public Customer(double serviceTime, int customerTask) {                                
    this.customerID = customerIndex;                                   
    Customer.customerIndex++;
    this.serviceTime = serviceTime; 
    this.customerTask = customerTask;   
  }   
    
  public double getServiceTime() {                                     
    return this.serviceTime;
  }   
    
  public int getCustomerID() {                                         
    return this.customerID;                                            
  }

  public String getCustomerTaskString() {
    if (this.customerTask == 0) {
      return "Deposit";
    } else if (this.customerTask == 1) {
      return "Withdrawal";
    } else {
      return "OpenAccount";
    }
  }  
  
  @Override
  public String toString() {
    String str = String.format("C" + "%d ", this.customerID);
    return str;
  }  

}
