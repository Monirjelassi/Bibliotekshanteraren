import java.util.UUID;

public record Book(UUID isbn, String title, String author) {

    @Override
    public String toString() {
        return title + " by " + author + " [" + isbn.toString().substring(0, 8) + "]";
    }
}
