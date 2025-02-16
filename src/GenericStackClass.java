/**
 * A generic class for stacks. In this class one can push (add),
 * pop (remove and get last added stack) and peek
 * (get last added stack not removing).
 * @param <T> Typ Parmater for flexible work with datatypes
 * @author Ramis Ekici
 * @version 16-02-2025
 */
public class GenericStackClass <T> {
    private T[] stacks; // an array with Typ Parameter
    private int counter;


    /**
     * Constructor to initialize the stack with a provided array and counter.
     * @param stacks the array of elements that represents the stack
     * @param counter the counter that keeps track of the current position in the stack
     */
    public GenericStackClass(T[] stacks, int counter) {
        this.stacks = stacks;
        this.counter = counter;
    }

    /**
     * Constructor to initialize the stack with a provided array and set the counter to 0.
     * @param stacks the array of elements that represents the stack
     */
    public GenericStackClass(T[] stacks) {
        this(stacks, 0);
    }

    public GenericStackClass() {
        this((T[]) new Object[10], 0);
    }

    /**
     * Constructor to initialize the stack with a given counter and a null array.
     * @param counter the counter that keeps track of the current position in the stack
     */
    public GenericStackClass(int counter) {
        this(null, counter);
    }

    /**
     * adding an element or stack into the array stack
     * @param item the element or stack, which will be added
     * @throws NullPointerException for null elements
     * @throws StackFullException for overflowed stack array
     */
    public void push(T item) throws NullPointerException, StackFullException{
        // Check if the item is null to prevent adding null to the stack
        if (item == null) throw new NullPointerException("Null items cannot be added to the stack.");

        // Check if the stack is full
        if (counter >= stacks.length) {
            throw new StackFullException("Stack overflow you can't add anything!");
        }

        // Add the item to the stack and plus the counter
        this.stacks[this.counter++] = item;
    }

    /**
     * adding an element or stack into the array stack.
     * If there ist no place left, the stack array becomes bigger
     * @param item the element or stack, which will be added
     * @throws NullPointerException for null elements
     */
    public void pushAutomatic(T item) throws NullPointerException {
        // Check if the item is null to prevent adding null to the stack
        if (item == null) throw new NullPointerException("Null items cannot be added to the stack.");

        // Check if the stack is full and make it bigger it if necessary
        if (counter >= stacks.length) {
            makeBigger();
        }

        // Add the item to the stack and plus the counter
        this.stacks[this.counter++] = item;
    }

    /**
     * it makes the stack array bigger for adding more elements
     */
    private void makeBigger() {
        // Double the size of the stack array
        T[] newStacks = (T[]) new Object[stacks.length * 2]; // Create a new array with double the size
        System.arraycopy(stacks, 0, newStacks, 0, stacks.length); // Copy the existing elements to the new array
        stacks = newStacks; // Point to the newly bigger array
    }


    /**
     * removing and returnin the last added element or stack
     * of the stack array
     * @return the last added element
     * @throws StackEmptyException for empty stack or stack array
     */
    public T pop() throws StackEmptyException{
        // Check if the stack is empty
        if (this.counter == 0) {
            throw new StackEmptyException("The stack is empty, cannot pop or return!");
        }

        // Move the counter to the previous element
        this.counter--;

        // Retrieve the element and clear the slot
        T stack = this.stacks[this.counter];
        this.stacks[this.counter] = null;

        // Return the popped element
        return stack;
    }

    /**
     * returning the last added element without removing.
     * @return the last added element
     * @throws StackEmptyException for empty stack or stack array
     */
    public T peek() throws StackEmptyException {
        // Check if the stack is empty
        if (this.counter == 0) {
            throw new StackEmptyException("The stack is empty, cannot peek!");
        }
        // last added stack
        T stack = this.stacks[this.counter - 1];

        // check if last added stack is null
        if (stack == null) throw new StackEmptyException("Stack is empty");

        return stack;
    }

    /**
     * A methode, with return a String list of the stack array.
     * @return output list of the stack array
     * @throws StackEmptyException for empty stack or stack array
     */
    public String list() throws StackEmptyException {
        if (this.counter == 0) {
        }

        String output = "";
        for (int i = 0; i < this.counter; i++) {
            if (this.stacks[i] != null) {
                output += this.stacks[i].toString();

                // checking if a semicolon is needed
                if (i < this.counter - 1) output += "; ";
            }
            else{
                throw new StackEmptyException("Stack is empty, cannot peek or return!");
            }
        }
        return output;
    }
}
