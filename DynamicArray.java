/**
 * Object adjusts the size of underlying array to accommodate any number of new
 * elements added to it. The class is written as generic.
 */
public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private static final int RESIZE_FACTOR = 2;

    /** The underlying array of the data structure */
    private String[] underlying;
    /** How many elements have been added to the underlying array */
    private int occupancy;

    /** Basic constructor */
    public DynamicArray(int size) {
        // Guard statement here to ensure that the user-provided size is legit.
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        // Create an Object array of the requested size, then cast it
        // as an array of objects E
        this.underlying = new String[size];
        // At the beginning the underlying array is empty
        this.occupancy = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Resize the underlying array as needed.
     * 
     * @param resize_by int factor multiply the size of the underlying array
     */

    private void resize() {
        // Create temporary array of DOUBLE the size of the underlying array
        String[] temp = new String[RESIZE_FACTOR * this.underlying.length]; // swapped magic number (2) with final RESIZE_FACTOR
        for (int i = 0; i < this.underlying.length; i++) {
            temp[i] = this.underlying[i];
        }
        this.underlying = temp;
    } // method resize

    public void add(String string) {
        // Is there room in the underlying array?
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        // At this point there is guaranteed room in the array, either
        // because we just doubled it in size or because there was enough
        // room for one more element to begin with.
        this.underlying[this.occupancy] = string;
        this.occupancy++;
    } // method add

    /**
     * method to find the position of an element in the underlying array
     * 
     * @return -1 if string not present, otherwise underlying array position of
     *         first occurrence of string.
     */

     /** Updated indexOf()
      * Method to find position of an element in the underlying array
      * @param string the string to search for
      * @return -1 if string not found, otherwise returns underlying array index of
      first occurence
      */

    public int indexOf(String string) {
        for (int i = 0; i < this.occupancy; i++) {
            if (this.underlying[i].equals(string)) {
                return i;
            }
        }
        
        return -1;
    } // method indexOf

    /** Method to tell if a string exists in the underlying array */

    /** Updated contains()
     * Method to tell if a string exists in the underlying array
     * @param string the string to search for
     * @return true if the string is in the underlying array; false otherwise
     */

    public boolean contains(String string) {
        for (int i = 0; i < this.occupancy; i++) {
            if (this.underlying[i].equals(string)) {
                return true; // string found
            }
        }

        return false; // string not found
    }


    /** Method to count how many times a string appears in the underlying array*/

    /** Updated countOf()
     * Method to count how many times a string appears in the underlying array
     * 
     * @param string the string to count in the underlying array
     * @return the number of occurences of the string in underlying array
     */

    public int countOf(String string) {
        int counter = 0; // Local counter variable

        // Only check filled possitions of underlying array
        for (int i = 0; i < this.occupancy; i++) {
            if (this.underlying[i].equals(string)) {
                counter ++;
            
            }
        }

        return counter; // 0 if string does not occur in underlying
    }

    /** method to remove items from the underlying array */

    /** Updated remove()
     * Removes the element at specified index from the array
     * Shifts remaining elements to the left
     * 
     * @param index the index of element to remove
     * @return the removed string, or null if index not valid
     */

    public String remove(int index) {

        // guard statement to handle invalid index

        if (index < 0 || index >= this.occupancy) {
            return null;
        }

        // local variable to hold removed element

        String removed = this.underlying[index];

        // Shift elements to left from index + 1 onwards

        for (int i = index; i < this.occupancy - 1; i++) {
            this.underlying[i] = this.underlying[i + 1];
        }

        // Null out the unused last element

        this.underlying[this.occupancy - 1] = null;
        this.occupancy --;

        return removed;
    }

    /** overload remove */ 

    /** Updated overload remove()
     * Removes first occurence of specified string from underlying
     * If string is not found, returns null
     * 
     * @param string the string to remove
     * @return the removed string, or null if not found
     */


    public String remove(String string) {
        int index = this.indexOf(string);

        if (index == -1) {
            return null; // string not found
            
        }
        return this.remove(index);
    }

    /** Complete this method */

    /** Updated toString()
     * Returns a string representation of the dynamic array
     * Includes only occupied elements and shows the current size (occupancy)
     * 
     * @return a string like this: DynamicArray(size=5): [a,b,c]
     */


    public String toString() {
        String result = "DynamicArray(size=" + this.occupancy + "): [";

        for (int i = 0; i < this.occupancy; i++) {
            result += this.underlying[i];
            if (i < this.occupancy - 1) {
                result += ", ";
            } 
        }
        result += "]";
        return result;
    }

} // class DynamicArray