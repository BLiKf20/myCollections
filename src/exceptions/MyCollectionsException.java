package exceptions;

/**
 * Исключение для пустой очереди
 */

public class MyCollectionsException extends Exception {
    public MyCollectionsException(String message) {
        super(message);
    }

    public MyCollectionsException(){
    }
}
