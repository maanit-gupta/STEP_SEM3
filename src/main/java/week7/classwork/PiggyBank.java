package week7.classwork;

public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || amount > savings) {
            return false;
        }
        savings -= amount;
        return true;
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank piggyBank = new PiggyBank("PB-1");
        piggyBank.deposit(100);
        System.out.println("Savings: " + piggyBank.getSavings());
        piggyBank.withdraw(30);
        System.out.println("Savings: " + piggyBank.getSavings());
        boolean accepted = piggyBank.withdraw(500);
        System.out.println("Withdraw 500 accepted: " + accepted + ", savings: " + piggyBank.getSavings());
    }
}
