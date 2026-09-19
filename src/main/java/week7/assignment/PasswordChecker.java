package week7.assignment;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        }
        if (length < 10) {
            return "Medium";
        }
        return "Strong";
    }

    public static void main(String[] args) {
        PasswordChecker weak = new PasswordChecker("abcd");
        PasswordChecker medium = new PasswordChecker("abcdefgh");
        PasswordChecker strong = new PasswordChecker("abcdefghijkl");
        System.out.println(weak.getStrength());
        System.out.println(medium.getStrength());
        System.out.println(strong.getStrength());
    }
}
