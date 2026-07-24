import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EnrollmentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        HashMap<String, ArrayList<String>> enrollments =
                new HashMap<>();
        String[] validPrograms = {"BSIT", "BSCS"};
        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: { // Register Student
                    System.out.println("---REGISTER STUDENT---");
                    System.out.print("Student ID : ");
                    String id = sc.nextLine();
                    System.out.print("Full Name : ");
                    String name = sc.nextLine();
                    System.out.println("Program : ");
                    String program = sc.nextLine();
                    System.out.println("Year Level : ");
                    int yearLevel = Integer.parseInt(sc.nextLine());
                    // TODO: read name, program, year level
                    // TODO: validate program vs validPrograms
                    // TODO: validate yearLevel is 1..4
                    students.add(new Student(id, "", "", 1));
                    System.out.println("[OK] Registered!");
                    break;
                }
                case 2: {
                    // TODO: Add Course Offering
                    System.out.println("--- ADD COURSE OFFERING ---");
                    System.out.println("Course Code : ");
                    String code = sc.nextLine();
                    System.out.println("Title : ");
                    String title = sc.nextLine();
                    System.out.println("Units : ");
                    int units = Integer.parseInt(sc.nextLine());
                    System.out.println("Capacity : ");
                    int capacity = Integer.parseInt(sc.nextLine());

                    course.add(new Course(code, title, units, capacity));
                    System.out.println("[OK] Course offering added");
                    break;
                }
                case 3: { // TODO: Enroll Student to Course
                    System.out.println("--- ENROLL STUDENT ---");
                    System.out.println("Student ID : ");
                    String id = sc.nextLine();
                    System.out.println("Course Code : ");
                    String code = sc.nextLine();

                    Student student = findStudent(students, id);
                    Course course = findCourse(courses, code);
                    break;
                }

                case 4: {
                    System.out.println("--- ALL STUDENT --- ");
                    if (students.isEmpty()) {
                        System.out.println("No Students Yet.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s.describe());
                        }
                    }

                    case 5: {
                        System.out.println("--- ALL COURSE ---");
                        if (courses.isEmpty()) {
                            System.out.println("no course yet.");
                        } else {
                            for (Course c : courses) {
                                System.out.println(c.getCourseCode()) + " " + c.getTitle()
                                        + " " + c.getUnits() + " units "
                                        + c.getEnrolledCount() + "/" + c.getCapacity();
                            }
                        }
                        break;
                    }
                    case 6: {
                        System.out.print("Student ID : ");
                        String id = sc.nextLine();
                        Student student = findStudent(students, id);


                    }
                }
            }
            System.out.println("---------------------------");
            System.out.println("Total Units : " + totalUnits);
        }
        break
    }
                // TODO: cases 4, 5, 6
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    static void printMenu() {
        System.out.println("[1] Register Student");
        // ... print the rest of the menu
        System.out.print("Enter choice: ");
    }
}

static void printMenu() {
    System.out.println(" LICEO ENROLLMENT SYSTEM (CLI)");
    System.out.println("================================");
    System.out.println("[1] Register Student");
    System.out.println("[2] Add course Offering");
    System.out.println("[3] Enroll Student to Course");
    System.out.println("[4] View all Students");
    System.out.println("[5] View All Courses");
    System.out.println("[6] View student Load (Courses + Units)");
    System.out.println("[0] Exit");
}

static Student findStudent(ArrayList<Student> list,
                           String id) {
    for (Student s : list) {
        if (s.getStudentId().equals(id)) {
            return s;
        }
    }
    return null; // not found
}

void main() {
}




