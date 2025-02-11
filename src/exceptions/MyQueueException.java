package exceptions;

/**
 * Исключение для пустой очереди
 */

public class MyQueueException extends Exception {
    public MyQueueException(String message) {
        super(message);
    }

    public MyQueueException(){
    }
}
