/**
 * The Array<T> for CS2030S 
 *
 * @author Althea Chua
 * @version CS2030S AY22/23 Semester 2
 */
class Array<T extends Comparable<T>> { // TODO: Change to bounded type parameter
  private T[] array;

  public Array(int size) {
    @SuppressWarnings({"unchecked", "rawtypes"})
    // the only way to add items into the array is through set method which 
    // guarantees it is of type T
    T[] temp = (T[]) new Comparable[size];
    this.array = temp;
  }

  public void set(int index, T item) {
    this.array[index] = item;
  }

  public T get(int index) {
    return this.array[index];
  }

  public T min() {
    if (this.array.length == 0) {
      return null;
    }
    T min = this.array[0];
    for (T item : array) {
      if (item.compareTo(min) == -1) { // current min is more than obj
        min = item;
      }  
    }
    return min;
  }
  
  public int getLength() {
    return this.array.length;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < array.length; i++) {
      s.append(i + ":" + array[i]);
      if (i != array.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
