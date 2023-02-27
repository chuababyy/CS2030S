class Bank {

  private Array<BankCounter> counters;

  private Queue<Customer> entranceQueue;

  public Bank(int numOfCounters, int entranceQueueLen, int counterQueueLen) {
    this.entranceQueue = new Queue<>(entranceQueueLen);
    this.counters = new Array<BankCounter>(numOfCounters);
   
    for (int i = 0; i < numOfCounters; i++) {
      counters.set(i, new BankCounter(counterQueueLen));
    }
  }

  // to get the counterID of an available counter
  // returns -1 if no available counter
  public BankCounter isAvailCounter() {
    for (int i = 0; i < counters.getLength(); i++) {
      if (this.counters.get(i).getAvailable()) {
        return this.counters.get(i);
      }
    }
    return null;
  }
  
  public BankCounter getShortestCounterQueue() {
    BankCounter shortest = this.counters.min();
    if (shortest.isCounterQueueFull()) { // no avail counter q
      return null;
    } else {
      return shortest;
    }
  }
    
  public void makeAvailable(int counterNum) {
    this.counters.get(counterNum).makeAvailable();
  }

  public void makeUnAvailable(int counterNum) {
    this.counters.get(counterNum).makeUnAvailable();
  }  
  
  // reimplementing Queue methods for entrance queue 

  public boolean enqEntranceQueue(Customer c) {
    return this.entranceQueue.enq(c);
  }
  
  public Customer deqEntranceQueue() {
    return this.entranceQueue.deq();
  }

  public boolean isEntranceQueueFull() {
    return this.entranceQueue.isFull();
  }
  
  public boolean isEntranceQueueEmpty() {
    return this.entranceQueue.isEmpty();
  }

  @Override
  public String toString() {
    return this.entranceQueue.toString();
  }  
}
