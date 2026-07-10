import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from the menu.\n");
                continue;
            }

            switch (choice) {
                case 1: {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine().trim();
                    library.addBook(new Book(title, author));
                    break;
                }
                case 2: {
                    library.listBooks();
                    break;
                }
                case 3: {
                    System.out.print("Enter the title of the book to borrow: ");
                    String title = scanner.nextLine().trim();
                    library.borrowBook(title);
                    break;
                }
                case 4: {
                    System.out.print("Enter the title of the book to return: ");
                    String title = scanner.nextLine().trim();
                    library.returnBook(title);
                    break;
                }
                case 5: {
                    System.out.print("Enter the title of the book to search: ");
                    String title = scanner.nextLine().trim();
                    library.searchBook(title);
                    break;
                }
                case 0: {
                    System.out.println("Goodbye! Thank you for using the Library Information System.");
                    running = false;
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please select a valid menu option.\n");
                }
            }

            System.out.println(); // blank line for readability between iterations
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Library Information System");
        System.out.println("1. Add a book");
        System.out.println("2. List all books");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. Search a book");
        System.out.println("0. Exit");
    }
}