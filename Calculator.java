import java.util.Scanner;

public class Calculator {
    /**
     * @param args
     */
    // static field declaring scanner method
    private static final Scanner STDIN = new Scanner(System.in);

    private static final String ANSWER = "The answer is ";

    private static double[] getNumbers() {
        double[] numbers = new double[2];
        System.out.println("\nFirst number: ");
        numbers[0] = STDIN.nextDouble();
        System.out.println("\nSecond Number: ");
        numbers[1] = STDIN.nextDouble();
        return numbers;
    }

    public static void addNumbers() {
        double[] numbers = getNumbers();
        double sum = numbers[0] + numbers[1];
        System.out.println(ANSWER + numbers[0] + "+" + numbers[1] + "=" + sum);

    }

    public static void subtractNumbers() {
        double[] numbers = getNumbers();
        double difference = numbers[0] - numbers[1];
        System.out.println(ANSWER + numbers[0] + "-" + numbers[1] + "=" + difference);
    }

    public static void divideNumbers() {
        double[] numbers = getNumbers();
        try {
            double quotient = numbers[0] / numbers[1];
            System.out.println(ANSWER + numbers[0] + "/" + numbers[1] + "=" + quotient);
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
        double[] numbers = getNumbers();
        double product = numbers[0] * numbers[1];
        System.out.println(ANSWER + numbers[0] + "x" + numbers[1] + "=" + product);
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