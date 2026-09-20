public class Library {
    Book[] books = new Book[10];
    Member[] members = new Member[10];
    Loan[] loans = new Loan[10];
    int bookCount = 0;
    int memberCount = 0;
    int loanCount = 0;

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Book added");
        } else {
            System.out.println("Book inventory is full");
        }
    }

    public void showBooks() {
        for (Book book : books) {
            if (book != null) {
                Loan loan = findBookInLoan(book);
                if (loan != null) {
                    System.out.println(book + " Book is loaned out to " + loan.member().getName());
                } else {
                    System.out.println(book + " Book is available");
                }
            }
        }
    }

    public void addMember(Member member) {
        if (memberCount < members.length) {
            members[memberCount] = member;
            memberCount++;
            System.out.println("Member added");
        } else {
            System.out.println("Member inventory is full");
        }
    }

    public Book findBookByTitle(String titel) {
        for (Book book : books) {
            if (book != null && book.titel().equalsIgnoreCase(titel)) return book;
        }
        return null;
    }

    public Member findMemberByName(String name) {
        for (Member member : members) {
            if (member != null && member.getName().equalsIgnoreCase(name)) return member;
        }
        return null;
    }

    public void loanBook(Loan loan) {
        if (!loan.member().canLoan()) {
            System.out.println("Too many active loans");
        } else if (findBookInLoan(loan.book()) != null) {
            System.out.println("Book is already loaned out");
        } else if (loanCount < loans.length) {
            loans[loanCount] = loan;
            loanCount++;
            loan.member().incrementActiveLoans();
            System.out.println("Loan added");
        } else {
            System.out.println("Loan inventory is full");
        }
    }

    public Loan findBookInLoan(Book book) {
        for (int i = 0; i < loanCount; i++) {
            if (loans[i].book().equals(book)) {
                return loans[i];
            }
        }
        return null;
    }

    public void removeLoan(Loan loan) {
        for (int i = 0; i < loanCount; i++) {
            if (loans[i].equals(loan)) {
                for (int j = i; j < loanCount - 1; j++) {
                    loans[j] = loans[j + 1];
                }
                loanCount--;
                loan.member().decrementActiveLoans();
                return;
            }
        }
    }
}
