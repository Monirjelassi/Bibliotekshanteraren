import java.util.UUID;

public class Member {
    private final UUID id;
    private final String name;
    private int active_loans;


    public Member(UUID id, String name, int active_loans) {
        this.id = id;
        this.name = name;
        this.active_loans = active_loans;
    }

    public boolean canLoan() {
       return  active_loans < 2;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getActive_loans() {
        return active_loans;
    }

    public void setActive_loans(int active_loans) {
        this.active_loans = active_loans;
    }

    public void incrementActiveLoans() {
        active_loans++;
    }
    public void decrementActiveLoans() {
        active_loans--;
    }
}
