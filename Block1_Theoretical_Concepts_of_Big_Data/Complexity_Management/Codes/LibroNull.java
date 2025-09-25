public class LibroNull {
    private String author;

    public LibroNull(String author) {
        this.author = author;
    }

    // Traditional version: may return null.
    // This forces callers to perform manual null checks and is the source
    // of many NullPointerExceptions when checks are forgotten.
    public String getAuthor() {
        return author; // could be null
    }

    public static void main(String[] args) {
        // Create a book whose author is unknown (represented by null)
        LibroNull book = new LibroNull(null);

        // Manual null-check before dereferencing to avoid NullPointerException
        if (book.getAuthor() != null) {
            System.out.println("Author: " + book.getAuthor());
        } else {
            System.out.println("Author unknown");
        }

        // Uncommenting the next line would throw a NullPointerException
        // System.out.println(book.getAuthor().toUpperCase());
    }
}
