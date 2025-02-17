public class Main {
    public static void main(String[] args) {
        GenericUtils gutil = new GenericUtils();

        String[] textArray = {"einz", "zwei", "drei", "vier", "fünf"};

        // Ausgabe des Original-Arrays
        System.out.println("Original Array: " + gutil.getArrayString(textArray));

        // Array umkehren
        gutil.reverse(textArray);

        // Ausgabe des umgekehrten Arrays
        System.out.println("Reversed Array: " + gutil.getArrayString(textArray));
    }
}