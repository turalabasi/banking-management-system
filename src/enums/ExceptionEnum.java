package enums;

public enum ExceptionEnum {
    CUSTOMER_NOTFOUND_EXCEPTION("customer not found: "),
    ACCOUNT_TYPE_EXCEPTION("You can`t  send to yourself"),
    EMPTY_LIST_EXCEPTION("Empty List Exception"),
    WRONG_PARAMETER_EXCEPTION("Wrong Parameter :"),
    LOW_BALANCE_EXCEPTION("Low balance: ");

    ExceptionEnum(String message) {
        this.message=message;
    }
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

