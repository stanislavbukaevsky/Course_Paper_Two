package pro.sky.coursepapertwo.Exception;

public class QuestionAlreadyAddedException extends Exception {
    public QuestionAlreadyAddedException() {
    }

    public QuestionAlreadyAddedException(String message) {
        super(message);
    }

    public QuestionAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    public QuestionAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
