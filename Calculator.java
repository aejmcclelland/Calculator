import java.util.Scanner;

public class Calculator {
    /**
     * @param args
     */
    // static field declaring scanner method
    private static final Scanner STDIN = new Scanner(System.in);

    private static int[] getNumbers() {
        int[] numbers = new int[2];
        System.out.println("\nFirst number: ");
        numbers[0] = STDIN.nextInt();
        System.out.println("\nSecond Number: ");
        numbers[1] = STDIN.nextInt();
        return numbers;
    }

    public static void addNumbers() {
        int[] numbers = getNumbers();
        int sum = numbers[0] + numbers[1];
        System.out.println("The answer is " + numbers[0] + "+" + numbers[1] + "=" + sum);

    }

    public static void subtractNumbers() {
        int[] numbers = getNumbers();
        int difference = numbers[0] - numbers[1];
        System.out.println("The answer is " + numbers[0] + "-" + numbers[1] + "=" + difference);
    }

    public static void divideNumbers() {
        int[] numbers = getNumbers();
        try {
            int quotient = numbers[0] / numbers[1];
            System.out.println("The answer is " + numbers[0] + "/" + numbers[1] + "=" + quotient);
        } catch (ArithmeticException e) {
            Throwable cause = e.getCause();
            if (cause instanceof ArithmeticException && cause.getMessage().equals("/ by zero")) {
                System.out.println("Cannot divide by zero.");
            } else {
                System.out.println("Division error: " + e.getMessage());
            }
        }
    }

    public static void multiplyNumbers() {
        int[] numbers = getNumbers();
        int product = numbers[0] * numbers[1];
        System.out.println("The answer is " + numbers[0] + "x" + numbers[1] + "=" + product);
    }

    public static void main(String[] args) {

        int choice;
        do {
            // Print out the menu
            System.out.println("\nCalculator");
            System.out.println("Choose the operation you want to perform");
            System.out.println("\n1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Division");
            System.out.println("4. Multiplication");
            System.out.println("5. Exit");

            choice = STDIN.nextInt();

            switch (choice) {
                case 1:
                    addNumbers();
                    break;
                case 2:
                    subtractNumbers();
                    break;
                case 3:
                    divideNumbers();
                    break;
                case 4:
                    multiplyNumbers();
                    break;
                case 5:
                    System.out.println("I'm done with sums! Exit!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select from the menu");
                    break;
            }
        } while (choice != 5);

    }
}