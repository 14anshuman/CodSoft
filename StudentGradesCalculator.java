import java.util.Scanner;

public class StudentGradesCalculator {
    public static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int i = 0; i < marks.length; i++) {
            total += marks[i];
        }
        return total;
    }

    public static double calculateAvgPercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    public static String calculateGrade(double avgPercentage) {
        if (avgPercentage >= 90) {
            return "A+";
        } else if (avgPercentage >= 80) {
            return "A";
        } else if (avgPercentage >= 70) {
            return "B";
        } else if (avgPercentage >= 60) {
            return "C";
        } else if (avgPercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input the number of subjects
        System.out.println("Enter number of subjects:");
        int numSubjects = sc.nextInt();
        int[] marks = new int[numSubjects];
        // Input marks for each subjects
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter marks for subject " + (i + 1) + " out of 100" + ":");
            marks[i] = sc.nextInt();
        }
        int totalMarks = StudentGradesCalculator.calculateTotalMarks(marks);
        double avgPercentage = StudentGradesCalculator.calculateAvgPercentage(totalMarks, numSubjects);
        String grade = StudentGradesCalculator.calculateGrade(avgPercentage);
        // Display the results
        System.out.println("Total Marks:" + totalMarks);
        System.out.println("Average Percentage:" + avgPercentage);
        System.out.println("Grade obtained: " + grade);
        sc.close();
    }
}
