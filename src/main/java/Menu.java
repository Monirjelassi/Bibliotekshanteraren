import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void startMenu(){

        boolean running = true;

        while (running) {
            showmenu(); //Prints out the menu.
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter book name: ");
                    break;
                case 2:
                    System.out.println("Enter member name: ");
                    break;
                case 3:
                    System.out.println("book ID: ");
                    break;
                case 4:
                    System.out.println("book ID: ");
                    break;
                case 5:
                    System.out.println("Search book ID: ");
                    break;
                case 6:
                    //showing all books
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
    private void showmenu(){
        System.out.println("1. Add book");
        System.out.println("2. Register member");
        System.out.println("3. Loan book");
        System.out.println("4. Return book");
        System.out.println("5. Search book");
        System.out.println("6. Show all books");
        System.out.println("7. Quit");
        System.out.print("Choose an option: ");
    }

}
