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
    GenericStackClass(T[] stacks, int counter) {
        this.stacks = stacks;
        this.counter = counter;
    }

    /**
     * Constructor to initialize the stack with a provided array and set the counter to 0.
     * @param stacks the array of elements that represents the stack
     */
    GenericStackClass(T[] stacks) {
        this(stacks, 0);
    }

    /**
     * Default constructor that initializes the stack with a null array and counter set to 0.
     */
    GenericStackClass() {
        this(null, 0);
    }

    /**
     * Constructor to initialize the stack with a given counter and a null array.
     * @param counter the counter that keeps track of the current position in the stack
     */
    GenericStackClass(int counter) {
        this(null, counter);
    }

    /**
     * adding an element or stack into the array stack
     * @param item the element or stack, which will be added
     */
    public void push(T item) {
        // Check if the item is null to prevent adding null to the stack
        if (item == null) throw new NullPointerException("Null items cannot be added to the stack.");

        // Check if the stack is full
        if (counter >= stacks.length) {
            throw new StackFullException("Stack overflow you can't add anything!");
        }

        // Add the item to the stack and increment the counter
        this.stacks[this.counter++] = item;
    }

    /**
     * removing and returnin the last added element or stack
     * of the stack array
     * @return the last added element
     */
    public T pop() {
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
     */
    public T peek() {
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
     */
    public String list() {
        if (this.counter == 0) {
            throw new StackEmptyException("The stack is empty, nothing to list!");
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
