import java.util.UUID;

public class Menu {
    Library library = new Library();

    public void startMenu() {

        boolean running = true;

        while (running) {
            showmenu(); //Prints out the menu.
            int choice;
            try {
                choice = Integer.parseInt(IO.readln("Choose an option: "));
            } catch (NumberFormatException e) {
                IO.println("Please enter a number! (1-7)");
                continue;
            }
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    loanBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    searchBookOrAuthor();
                    break;
                case 6:
                    showAllBooks();
                    break;
                case 7:
                    IO.println("Shutting down...");
                    running = false;
                    break;
                default:
                    IO.println("Invalid choice");
            }
        }
    }

    private void showmenu() {
        IO.println("Bibliotekshanteraren");
        IO.println("====================");
        IO.println("1. Add book");
        IO.println("2. Register member");
        IO.println("3. Loan book");
        IO.println("4. Return book");
        IO.println("5. Search book");
        IO.println("6. Show all books");
        IO.println("7. Quit");
    }

    private void addBook() {
        String bookName = IO.readln("Enter book name: ");
        String memberName = IO.readln("Enter author name: ");
        UUID isbn = UUID.randomUUID();
        Book book = new Book(isbn, bookName, memberName);
        library.addBook(book);
    }

    private void showAllBooks() {
        library.showBooks();
    }

    private void addMember() {
        String memberName = IO.readln("Enter member name: ");
        Member member = new Member(UUID.randomUUID(), memberName, 0);
        library.addMember(member);
    }

    private void loanBook() {
        String bookTitle = IO.readln("Enter book title: ");
        String memberName = IO.readln("Enter member name: ");

        Book book = library.findBookByTitle(bookTitle);
        Member member = library.findMemberByName(memberName);

        if (book == null || member == null) {
            IO.println("Book or member not found");
            return;
        }

        Loan loan = new Loan(book, member);
        library.loanBook(loan);
    }

    private void returnBook() {
        String bookTitle = IO.readln("Enter book title for return: ");
        Loan loan = library.findBookInLoan(library.findBookByTitle(bookTitle));
        if (loan == null) {
            IO.println("Book not found");
        } else {
            library.removeLoan(loan);
            IO.println("Book successfully returned!");
        }

    }

    private void searchBookOrAuthor() {
        String search = IO.readln("Enter book title or author name for search: ");
        library.searchBookOrAuthor(search);
    }

}
