/**
 * Test class for the GenericStackClass using integers (number stack).
 * This class demonstrates pushing, popping, peeking, and listing elements for an integer stack.
 * @author Ramis Ekici
 * @version 16-02-2025
 */
public class NumberStackTest {
    public static void main(String[] args) {
        // Create a number stack with a capacity of 10 and default constructore
        GenericStackClass<Integer> numberStack = new GenericStackClass<>();

        try {
            // Push elements onto the stack
            numberStack.pushAutomatic(10);
            numberStack.pushAutomatic(20);
            numberStack.pushAutomatic(30);

            // List the stack elements
            System.out.println("Stack contents: " + numberStack.list()); // Expected: 10; 20; 30

            // Peek the top element
            System.out.println("Peek top element: " + numberStack.peek()); // Expected: 30

            // Pop an element and list again
            numberStack.pop();
            System.out.println("Stack after pop: " + numberStack.list()); // Expected: 10; 20

        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (StackFullException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("An unexpected Error: " + e.getMessage());
        }


        // Create a number stack with a capacity of 10
        GenericStackClass<Integer> numberStack2 = new GenericStackClass<>(new Integer[10]);

        try {
            // Push elements onto the stack
            numberStack2.push(10);
            numberStack2.push(20);
            numberStack2.push(30);

            // List the stack elements
            System.out.println("Stack contents: " + numberStack2.list()); // Expected: 10; 20; 30

            // Peek the top element
            System.out.println("Peek top element: " + numberStack2.peek()); // Expected: 30

            // Pop an element and list again
            numberStack2.pop();
            System.out.println("Stack after pop: " + numberStack2.list()); // Expected: 10; 20

        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (StackFullException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected Error: " + e.getMessage());
        }

        // Additional Exception case
        try {
            numberStack2.pop();
            numberStack2.pop();
            numberStack2.pop(); // This should do a StackEmptyException
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage()); // Expected: Error for empty stack
        }

        // Create a text stack with a capacity of 10 and default constructor
        GenericStackClass<String> textStack = new GenericStackClass<>();

        try {
            // Push elements into the stack
            textStack.pushAutomatic("Hello");
            textStack.pushAutomatic("World");
            textStack.pushAutomatic("Generic");

            // List the stack elements
            System.out.println("Stack contents: " + textStack.list()); // Expected: Hello; World; Generic

            // Peek the top element
            System.out.println("Peek top element: " + textStack.peek()); // Expected: Generic

            // Pop an element and list again
            textStack.pop();
            System.out.println("Stack after pop: " + textStack.list()); // Expected: Hello; World
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected Error: " + e.getMessage());
        }


        // Create a text stack with a capacity of 10
        GenericStackClass<String> textStack2 = new GenericStackClass<>(new String[10]);

        try {
            // Push elements onto the stack
            textStack2.push("Hello");
            textStack2.push("World");
            textStack2.push("Generic");

            // List the stack elements
            System.out.println("Stack contents: " + textStack2.list()); // Expected: Hello; World; Generic

            // Peek the top element
            System.out.println("Peek top element: " + textStack2.peek()); // Expected: Generic

            // Pop an element and list again
            textStack2.pop();
            System.out.println("Stack after pop: " + textStack2.list()); // Expected: Hello; World
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (StackFullException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected Error: " + e.getMessage());
        }

        // Additional Exception case
        try {
            textStack2.pop();
            textStack2.pop();
            textStack2.pop(); // This should do a StackEmptyException
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage()); // Expected: Error for empty stack
        }
    }
}
