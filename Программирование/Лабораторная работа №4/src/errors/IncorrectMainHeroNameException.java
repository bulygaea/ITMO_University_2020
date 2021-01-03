package errors;

// Unchecked exception
public class IncorrectMainHeroNameException extends RuntimeException {
    private String name;

    public IncorrectMainHeroNameException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
