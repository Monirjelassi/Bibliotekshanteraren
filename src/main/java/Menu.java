import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Menu {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    public void startMenu() {

        boolean running = true;

        while (running) {
            showmenu(); //Prints out the menu.
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number! (1-7)");
                scanner.nextLine();
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
                    System.out.println("Search book: (Titel or Author");
                    break;
                case 6:
                    showAllBooks();
                    break;
                case 7:
                    System.out.println("Shutting down...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }

    private void showmenu() {
        System.out.println("Bibliotekshanteraren");
        System.out.println("====================");
        System.out.println("1. Add book");
        System.out.println("2. Register member");
        System.out.println("3. Loan book");
        System.out.println("4. Return book");
        System.out.println("5. Search book");
        System.out.println("6. Show all books");
        System.out.println("7. Quit");
        System.out.print("Choose an option: ");
    }

    private void addBook() {
        System.out.println("Enter book name: ");
        String bookName = scanner.nextLine();
        System.out.println("Enter author name: ");
        String memberName = scanner.nextLine();
        UUID isbn = UUID.randomUUID();
        Book book = new Book(isbn, bookName, memberName);
        library.addBook(book);
    }

    private void showAllBooks() {
        library.showBooks();
    }

    private void addMember() {
        System.out.println("Enter member name: ");
        String memberName = scanner.nextLine();
        Member member = new Member(UUID.randomUUID(), memberName, 0);
        library.addMember(member);
    }

    private void loanBook() {
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter member name: ");
        String memberName = scanner.nextLine();

        Book book = library.findBookByTitle(bookTitle);
        Member member = library.findMemberByName(memberName);

        if (book == null || member == null) {
            System.out.println("Book or member not found");
            return;
        }

        Loan loan = new Loan(book, member);
        library.loanBook(loan);
    }

    private void returnBook() {
        System.out.println("Enter book title for return: ");
        String bookTitle = scanner.nextLine();
        Loan loan = library.findBookInLoan(library.findBookByTitle(bookTitle));
        if (loan == null) {
            System.out.println("Book not found");
        } else {
            library.removeLoan(loan);
            System.out.println("Book successfully returned!");
        }

    }

}
