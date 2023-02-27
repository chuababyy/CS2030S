import java.util.Scanner;

/**
 * This class implements a bank simulation.
 *
 * @author Wei Tsang
 * @version CS2030S AY21/22 Semester 2
 */ 
class BankSimulation extends Simulation {
  /** 
   * The availability of counters in the bank. 
   */
  //  public boolean[] available;

  /** 
   * The list of customer arrival events to populate
   * the simulation with.
   */
  private Event[] initEvents;
  
  private BankCounter bankCounter;
  /** 
   * Constructor for a bank simulation. 
   *
   * @param sc A scanner to read the parameters from.  The first
   *           integer scanned is the number of customers; followed
   *           by the number of service counters.  Next is a 
   *           sequence of (arrival time, service time) pair, each
   *           pair represents a customer.
   */
  public BankSimulation(Scanner sc) {

    initEvents = new Event[sc.nextInt()];
    BankCounter bankCounter = new BankCounter(sc.nextInt());

    int i = 0;
    while (sc.hasNextDouble()) {
      double arrivalTime = sc.nextDouble();
      Customer customer = new Customer(sc.nextDouble());
      initEvents[i++] = new ArrivalEvent(arrivalTime, customer, bankCounter);
    }
  }

  /**
   * Retrieve an array of events to populate the 
   * simulator with.
   *
   * @return An array of events for the simulator.
   */
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}
