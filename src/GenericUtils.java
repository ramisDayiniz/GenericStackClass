import java.lang.Number;
/**
 * Utility class for generic array operations, providing methods to reverse an array
 * and convert it to a formatted string representation.
 * @author Ramis Ekici
 * @version 17-02-2025
 */
public class GenericUtils {
    /**
     * Reverses the order of elements in the provided array.
     * @param <T> The type of the array elements.
     * @param stackArray The array to be reversed
     * @return The reversed array.
     * @throws NullPointerException  If the input array is null or empty.
     * @throws StackEmptyException   If any element in the array is null or empty.
     */
    public static <T> T[] reverse(T[] stackArray) throws NullPointerException, StackEmptyException{
        // Null check
        if (stackArray == null || stackArray.length == 0) {
            throw new NullPointerException();
        }

        int length = stackArray.length;
        int j = 0;

        // while i is less than j
        for (int i = length - 1; i > j; i--) {
            // Optional: Null-Prüfung
            if (stackArray[i] == null || stackArray[j] == null) {
                throw new StackEmptyException("Stack contains null at positions i=" + i + ", j=" + j);
            }

            // switching the Object by templating the object (NOT ARRAY)
            T temp = stackArray[i];
            stackArray[i] = stackArray[j];
            stackArray[j] = temp;
            j++;
        }
        return stackArray;
    }



    /**
     * Converts the provided array to a space-separated string representation.
     * @param <T> The type of the array elements.
     * @param stackArray The array to be converted to a string
     * @return A string representation of the array, with each element separated by a space.
     * @throws NullPointerException  If the input array is null or empty.
     * @throws StackEmptyException   If any element in the array is null.
     */
    public static <T> String getArrayString(T[] stackArray) throws NullPointerException, StackEmptyException{
        // Null check
        if (stackArray == null || stackArray.length == 0) {
            throw new NullPointerException();
        }
        // Output of Array in String
        StringBuilder stringBuilder = new StringBuilder();
        // till stackArray is finished
        for (T stack : stackArray) {
            if(stack == null) throw new StackEmptyException("Stack is empty");
            stringBuilder.append(stack).append(" ");
        }
        return stringBuilder.toString();
    }

    /**
     * Sums all the elements of an array of type T, where is a subclass of Number.
     * The method calculates the sum by converting each element to a double.
     * @param <T> The generic type that must extend Number.
     * @param stackArray The array of numbers to be summed.
     * @return The sum of all elements in the array as a double.
     * @throws NullPointerException If the input array is null or empty.
     * @throws StackEmptyException If any element in the array is null.
     */
    public static <T extends Number> double sum(T[] stackArray) throws NullPointerException, StackEmptyException{
        if (stackArray == null || stackArray.length == 0) {
            throw new NullPointerException();
        }
        double sum = 0.0;
        for (T stack : stackArray) {
            if (stack == null) throw new StackEmptyException("Stack is empty");
            sum += stack.doubleValue();
        }
        return sum;
    }
}
