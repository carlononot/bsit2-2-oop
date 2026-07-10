import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.describe());
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("The library has no books yet.");
            return;
        }

        System.out.println("\n----- Library Catalog -----");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            String status = b.isBorrowed() ? "Borrowed" : "Available";
            System.out.printf("%d. %s | %s | %s%n",
                    i + 1, b.getTitle(), b.getAuthor(), status);
        }
        System.out.println("----------------------------");
    }

    private Book findBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public void borrowBook(String title) {
        Book b = findBook(title);
        if (b == null) {
            System.out.println("No book found with title \"" + title + "\".");
            return;
        }
        if (b.borrow()) {
            System.out.println("You have borrowed: " + b.describe());
        } else {
            System.out.println("Sorry, \"" + b.getTitle() + "\" is already borrowed.");
        }
    }

    public void returnBook(String title) {
        Book b = findBook(title);
        if (b == null) {
            System.out.println("No book found with title \"" + title + "\".");
            return;
        }
        if (b.returnBook()) {
            System.out.println("Thank you for returning: " + b.describe());
        } else {
            System.out.println("\"" + b.getTitle() + "\" was not borrowed.");
        }
    }

    public void searchBook(String title) {
        Book b = findBook(title);
        if (b != null) {
            System.out.println("Found: " + b.describe());
        } else {
            System.out.println("No book found with title \"" + title + "\".");
        }
    }
}