import java.util.UUID;

public class Member {
    private final UUID id;
    private final String name;
    private int activeLoans;


    public Member(UUID id, String name, int activeLoans) {
        this.id = id;
        this.name = name;
        this.activeLoans = activeLoans;
    }

    public boolean canLoan() {
       return  activeLoans < 2;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getActiveLoans() {
        return activeLoans;
    }

    public void setActiveLoans(int activeLoans) {
        this.activeLoans = activeLoans;
    }

    public void incrementActiveLoans() {
        activeLoans++;
    }

    public void decrementActiveLoans() {
        activeLoans--;
    }
}
