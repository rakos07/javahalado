package hu.me;

public class ValidatorResponse {
    private boolean valid;
    private ErrorMessage errorMessage;

    public ValidatorResponse(boolean valid, ErrorMessage errorMessage){
        this.valid = valid;
        this.errorMessage = errorMessage;
    }

    public boolean isValid() {
        return valid;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
