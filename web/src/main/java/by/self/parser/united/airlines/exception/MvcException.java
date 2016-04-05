package by.self.parser.united.airlines.exception;

public class MvcException extends Exception {

    public MvcException() {
    }

    public MvcException(String message, Throwable cause) {
        super(message, cause);
    }

    public MvcException(String message) {
        super(message);
    }

    public MvcException(Throwable cause) {
        super(cause);
    }
}
