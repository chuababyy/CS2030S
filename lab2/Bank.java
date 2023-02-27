class Bank {

  private BankCounter[] counters;

  private Queue queue;

  public Bank(int numOfCounters, int maxQueueSize) {
    this.queue = new Queue(maxQueueSize);
    this.counters = new BankCounter[numOfCounters];
   
    for (int i = 0; i < numOfCounters; i++) {
      counters[i] = new BankCounter();
    }
  }

  // to get the counterID of an available counter
  // returns -1 if no available counter
  public int hasAvailCounter() {
    for (int i = 0; i < counters.length; i++) {
      if (this.counters[i].getAvailable()) {
        return i;
      }
    }
    return -1;
  }
  
  public void makeAvailable(int counterNum) {
    this.counters[counterNum].makeAvailable();
  }

  public void makeUnAvailable(int counterNum) {
    this.counters[counterNum].makeUnAvailable();
  }  

  public Queue getQueue() {
    return this.queue;
  } 

  @Override
  public String toString() {
    return this.queue.toString();
  }  
}
