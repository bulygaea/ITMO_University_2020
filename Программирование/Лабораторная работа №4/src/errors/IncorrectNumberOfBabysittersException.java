package errors;

// Checked exception
public class IncorrectNumberOfBabysittersException extends Exception {
    private final int actualNumber;

    public IncorrectNumberOfBabysittersException(int actualNumber) {
        this.actualNumber = actualNumber;
    }

    public int getActualNumber() {
        return actualNumber;
    }
}
