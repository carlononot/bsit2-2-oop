import java.util.Scanner;

public class Main {

    static final int MAX_STUDENTS = 10;

    static int[] ids = new int[MAX_STUDENTS];
    static String[] names = new String[MAX_STUDENTS];
    static int[] ages = new int[MAX_STUDENTS];
    static String[] courses = new String[MAX_STUDENTS];
    static double[] grades = new double[MAX_STUDENTS];
    static boolean[] enrolled = new boolean[MAX_STUDENTS];


    static int studentCount = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    viewStatistics();
                    break;
                case 5:
                    System.out.println("Goodbye! Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        } while (choice != 5);

        scanner.close();
    }


    static void printMenu() {
        System.out.println("\n==== STUDENT INFORMATION SYSTEM ====");
        System.out.println("[1] Add Student");
        System.out.println("[2] View All Students");
        System.out.println("[3] Search Student ID");
        System.out.println("[4] View Statistics");
        System.out.println("[5] Exit");
    }

    static void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Student list is full! Cannot add more.");
            return;
        }

        System.out.println("--- Add New Student ---");

        int id = readInt("Student ID: ");

        String name;
        do {
            System.out.print("Full Name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            }
        } while (name.isEmpty());

        int age = readInt("Age: ");
        while (age <= 0) {
            System.out.println("Age must be positive.");
            age = readInt("Age: ");
        }

        System.out.print("Course: ");
        String course = scanner.nextLine().trim();

        double grade = readDouble("Grade (0-100): ");
        while (grade < 0 || grade > 100) {
            System.out.println("Grade must be between 0 and 100.");
            grade = readDouble("Grade (0-100): ");
        }

        System.out.print("Enrolled? (true/false): ");
        boolean isEnrolled = Boolean.parseBoolean(scanner.nextLine().trim());

        ids[studentCount] = id;
        names[studentCount] = name;
        ages[studentCount] = age;
        courses[studentCount] = course;
        grades[studentCount] = grade;
        enrolled[studentCount] = isEnrolled;

        studentCount++;

        System.out.println("Student added successfully!");
    }

    static void viewAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students recorded yet.");
            return;
        }

        System.out.println("\n--- All Students ---");
        System.out.printf("%-4s %-15s %-4s %-10s %-6s %-9s %-13s%n",
                "ID", "Name", "Age", "Course", "Grade", "Enrolled", "Standing");

        for (int i = 0; i < studentCount; i++) {
            String standing = getStanding(grades[i]);
            System.out.printf("%-4d %-15s %-4d %-10s %-6.2f %-9s %-13s%n",
                    ids[i], names[i], ages[i], courses[i], grades[i],
                    enrolled[i], standing);
        }
    }

    static String getStanding(double grade) {
        if (grade >= 90) {
            return "Dean's Lister";
        } else if (grade >= 75) {
            return "Passed";
        } else {
            return "Failed";
        }
    }

    static void searchStudent() {
        int searchId = readInt("Enter Student ID to search: ");
        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (ids[i] == searchId) {
                System.out.println("--- Student Found ---");
                System.out.println("ID: " + ids[i]);
                System.out.println("Name: " + names[i]);
                System.out.println("Age: " + ages[i]);
                System.out.println("Course: " + courses[i]);
                System.out.println("Grade: " + grades[i]);
                System.out.println("Enrolled: " + enrolled[i]);
                System.out.println("Standing: " + getStanding(grades[i]));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No student found with ID " + searchId);
        }
    }

    static void viewStatistics() {
        if (studentCount == 0) {
            System.out.println("No students recorded yet.");
            return;
        }

        double total = 0;
        double topGrade = -1;
        String topName = "";

        for (double g : grades) {
            total += g;
        }
        total = 0;
        for (int i = 0; i < studentCount; i++) {
            total += grades[i];
            if (grades[i] > topGrade) {
                topGrade = grades[i];
                topName = names[i];
            }
        }

        double average = total / studentCount;

        System.out.println("\n--- Class Statistics ---");
        System.out.println("Total Students: " + studentCount);
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.println("Top Student: " + topName + " (" + topGrade + ")");
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}