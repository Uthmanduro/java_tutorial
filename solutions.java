import java.util.Scanner;

public class solutions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        maxmin(scanner);

        checkDivisibleBy3(scanner);

        checkMultiplication(scanner);

        checkerPattern();

        bmiCalculator(scanner);

        taxCalculator(scanner);

        palindromeChecker(scanner);

        sumOfExtremes(scanner);

        scanner.close();
    }

    public static void maxmin(Scanner scanner) {

        // Declare an array to hold 5 integers
        int[] numbers = new int[5];

        System.out.println("Enter 5 integers:");

        // Populate the array with user inputs
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();

        }

        // Initialize min and max with the first element in the array
        int max = numbers[0];
        int min = numbers[0];

        // Loop through the array to find max and min
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        System.out.println("\nThe largest number is: " + max);
        System.out.println("The smallest number is: " + min);
    }

    public static void checkDivisibleBy3(Scanner scanner) {


        System.out.println("Enter a number");

        int number = scanner.nextInt();

        System.out.println(number % 3 == 0 ? "True" : "False");

//        scanner.close();
    }

    public static void checkMultiplication(Scanner scanner) {
//        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number");
        int number1 = scanner.nextInt();

        System.out.println("Enter second number");
        int number2 = scanner.nextInt();

        System.out.println(number1 * 3 % number2 * 2 == 0 ? "True" : "False");

        scanner.close();
    }

    public static void checkerPattern() {
        int rows = 8;  // Total number of rows

        for (int i = 0; i < rows; i++) {
            // For even-numbered rows
            if (i % 2 == 0) {
                System.out.println("* * * * * * * *");
            }
            // For odd-numbered rows
            else {
                System.out.println(" * * * * * * * *");
            }
        }
    }

    public static void bmiCalculator(Scanner input) {
        System.out.println("BMI Calculator");
        System.out.println("Choose unit system:");
        System.out.println("1. Imperial (pounds and inches)");
        System.out.println("2. Metric (kilograms and meters)");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = input.nextInt();

        double weight, height, bmi;

        if (choice == 1) {
            // Imperial units calculation
            System.out.print("Enter your weight in pounds: ");
            weight = input.nextDouble();
            System.out.print("Enter your height in inches: ");
            height = input.nextDouble();
            bmi = (weight * 703) / (height * height);
        } else {
            // Metric units calculation
            System.out.print("Enter your weight in kilograms: ");
            weight = input.nextDouble();
            System.out.print("Enter your height in meters: ");
            height = input.nextDouble();
            bmi = weight / (height * height);
        }

        // Display results
        System.out.printf("%nYour BMI is: %.1f%n", bmi);
        System.out.println("\nBMI Categories:");
        System.out.println("Underweight: less than 18.5");
        System.out.println("Normal:      between 18.5 and 24.9");
        System.out.println("Overweight:  between 25 and 29.9");
        System.out.println("Obese:       30 or greater");

        // Determine category
        System.out.print("\nYour category: ");
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }

    public static void taxCalculator(Scanner scanner) {
        final double BASE_TAX_RATE = 0.15;
        final double EXCESS_TAX_RATE = 0.20;
        final double TAX_THRESHOLD = 30000.0;

        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter the name of citizen " + i + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter the earnings for " + name + ": ");
            double earnings = scanner.nextDouble();
            scanner.nextLine();

            double tax;

            if (earnings <= TAX_THRESHOLD) {
                tax = earnings * BASE_TAX_RATE;
            } else {
                double baseTax = TAX_THRESHOLD * BASE_TAX_RATE;
                double excessTax = (earnings - TAX_THRESHOLD) * EXCESS_TAX_RATE;
                tax = baseTax + excessTax;
            }

            System.out.printf("Total tax for %s is: $%.2f%n%n", name, tax);
        }
    }

    public static void palindromeChecker(Scanner scanner) {
        int number;

        while (true) {
            System.out.print("Enter a five-digit integer: ");
            number = scanner.nextInt();

            if (number >= 10000 && number <= 99999) {
                break; // Valid 5-digit number
            } else {
                System.out.println("Error: Please enter a valid five-digit number.");
            }
        }

        int original = number;
        int reversed = 0;

        // Reverse the number
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        // Check if palindrome
        if (original == reversed) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }
    }

    public static void sumOfExtremes(Scanner scanner) {

        System.out.print("How many integers do you want to input? ");
        int count = scanner.nextInt();

        if (count <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        int number;
        int min, max;

        System.out.print("Enter number 1: ");
        number = scanner.nextInt();
        min = max = number;

        for (int i = 2; i <= count; i++) {
            System.out.print("Enter number " + i + ": ");
            number = scanner.nextInt();

            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        int sum = min + max;

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Sum of Min and Max: " + sum);
    }
}