public class Book {

    // Static variable 
    static String libraryName = "Central Library";

    // Instance variables
    String title;
    String author;
    final String isbn;  

    // Constructor using 'this' keyword
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method using instanceof
    void displayDetails(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("ISBN: " + book.isbn);
        } else {
            System.out.println("Not a Book object");
        }
    }

    // Main method
    public static void main(String[] args) {
        Book b1 = new Book("Clean Code", "Robert C. Martin", "ISBN101");
        Book b2 = new Book("Java Basics", "James Gosling", "ISBN102");

        Book.displayLibraryName();
        System.out.println();

        b1.displayDetails(b1);
        System.out.println();

        b2.displayDetails(b2);
    }
}
