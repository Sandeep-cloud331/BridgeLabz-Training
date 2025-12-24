public class Book {
    public String ISBN;          // public
    protected String title;      // protected
    private String author;       // private

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("978-1234567890", "Java Basics", "James");

        ebook.showDetails();
        ebook.setAuthor("James Gosling");

        System.out.println("Author: " + ebook.getAuthor());
    }
}

class EBook extends Book {

    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void showDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
    }
}
