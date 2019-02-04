package util;


public class ReportCardsException extends RuntimeException {

    public ReportCardsException(String msg, Exception innerException) {
        super(msg, innerException);
    }

    public ReportCardsException(String msg) {
        super(msg);
    }

}
