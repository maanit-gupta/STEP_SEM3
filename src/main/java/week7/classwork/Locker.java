package week7.classwork;

public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!code.equals(currentCode)) {
            return false;
        }
        code = newCode;
        return true;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        System.out.println("Change with correct code: " + locker.changeCode("1234", "5678"));
        System.out.println("Change with wrong code: " + locker.changeCode("0000", "9999"));
        System.out.println("Change with latest code: " + locker.changeCode("5678", "4321"));
    }
}
