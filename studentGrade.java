import java.util.Scanner;

public class studentGrade {
    public static void main(String[] args) {
        // Variables to store grade counts
        int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeOther = 0;

        // Variables for input
        String studentName;
        char letterGrade;

        // Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Constant for number of students
        final int NUM_STUDENTS = 5;

        System.out.println("=== Student Grade Counter Application ===");
        System.out.println("Please enter student information for " + NUM_STUDENTS + " students.");
        System.out.println("Enter student name followed by their letter grade (A, B, C, or D).");
        System.out.println();

        // Loop to input grades for all students
        for (int i = 1; i <= NUM_STUDENTS; i++) {
            System.out.println("Student " + i + ":");

            // Get student name
            System.out.print("Enter student name: ");
            studentName = scanner.nextLine();

            // Get student grade
            System.out.print("Enter letter grade for " + studentName + ": ");
            String gradeInput = scanner.nextLine();

            // Handle empty input or get first character
            if (gradeInput.length() > 0) {
                letterGrade = Character.toUpperCase(gradeInput.charAt(0));
            } else {
                letterGrade = '?';
            }

            // Use switch statement to count grades
            switch (letterGrade) {
                case 'A':
                    gradeA++;
                    System.out.println(studentName + " received an A grade.");
                    break;
                case 'B':
                    gradeB++;
                    System.out.println(studentName + " received a B grade.");
                    break;
                case 'C':
                    gradeC++;
                    System.out.println(studentName + " received a C grade.");
                    break;
                case 'D':
                    gradeD++;
                    System.out.println(studentName + " received a D grade.");
                    break;
                default:
                    gradeOther++;
                    System.out.println("Invalid grade entered for " + studentName + ". Grade '"
                            + letterGrade + "' not recognized.");
                    break;
            }

            System.out.println(); // Add spacing between students
        }

        // Display results
        System.out.println("======================================");
        System.out.println("           GRADE SUMMARY              ");
        System.out.println("======================================");
        System.out.printf("%-15s%s%n", "Grade", "Count");
        System.out.println("--------------------------------------");
        System.out.printf("%-15s%d%n", "A grades:", gradeA);
        System.out.printf("%-15s%d%n", "B grades:", gradeB);
        System.out.printf("%-15s%d%n", "C grades:", gradeC);
        System.out.printf("%-15s%d%n", "D grades:", gradeD);

        if (gradeOther > 0) {
            System.out.printf("%-15s%d%n", "Invalid grades:", gradeOther);
        }

        System.out.println("--------------------------------------");
        System.out.printf("%-15s%d%n", "Total students:", (gradeA + gradeB + gradeC + gradeD + gradeOther));
        System.out.println("======================================");

        // Calculate and display percentages
        System.out.println();
        System.out.println("GRADE DISTRIBUTION PERCENTAGES:");
        System.out.println("--------------------------------------");
        System.out.printf("A grades: %.1f%%%n", (gradeA * 100.0 / NUM_STUDENTS));
        System.out.printf("B grades: %.1f%%%n", (gradeB * 100.0 / NUM_STUDENTS));
        System.out.printf("C grades: %.1f%%%n", (gradeC * 100.0 / NUM_STUDENTS));
        System.out.printf("D grades: %.1f%%%n", (gradeD * 100.0 / NUM_STUDENTS));

        // Close scanner
        scanner.close();
    }
}
