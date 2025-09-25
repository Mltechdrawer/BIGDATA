import java.util.Optional;

public class LibroOptional {
    private String author;

    public LibroOptional(String author) {
        this.author = author;
    }

    // Modern version: returns an Optional to explicitly model absence.
    // Callers cannot accidentally dereference null; they must unwrap explicitly.
    public Optional<String> getAuthor() {
        return Optional.ofNullable(author);
    }

    public static void main(String[] args) {
        // Create a book whose author is unknown
        LibroOptional book = new LibroOptional(null);

        // Safer handling with Optional: provide a default value
        String authorOrDefault = book.getAuthor().orElse("Author unknown");
        System.out.println("Author: " + authorOrDefault);

        // Or execute logic only when a value is present
        book.getAuthor().ifPresent(a -> System.out.println("Uppercased: " + a.toUpperCase()));

        // Or fail fast with a clear exception if absence is unexpected
        // String mustExist = book.getAuthor().orElseThrow(() -> new IllegalStateException("Author must exist"));
    }
}
