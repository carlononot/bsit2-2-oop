public class Book {

    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public boolean borrow() {
        if (isBorrowed) {
            return false; // already borrowed, cannot borrow again
        }
        isBorrowed = true;
        return true;
    }

    public boolean returnBook() {
        if (!isBorrowed) {
            return false;
        }
        isBorrowed = false;
        return true;
    }

    public String describe() {
        String status = isBorrowed ? "Borrowed" : "Available";
        return String.format("\"%s\" by %s [%s]", title, author, status);
    }

    @Override
    public String toString() {
        return describe();
    }
}