package exception;

public class CsvParserException extends RuntimeException{

    public CsvParserException(String message, Throwable cause) {
        super(message, cause);
    }

}
