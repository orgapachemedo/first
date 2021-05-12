package ShiYanEr.ExceptionTest;
public class NoDigit extends Exception {
    public NoDigit() {
    }
    public NoDigit(String message) {

        super(message);
    }
    public NoDigit(Throwable cause) {
        super(cause);
    }
}
