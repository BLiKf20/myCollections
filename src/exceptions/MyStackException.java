package exceptions;

/**
 * Если пытаемся добавить в заполненный стек или пытаемся извлечь элементы из пустого стека
 */

public class MyStackException extends Exception {
    public MyStackException(String message) {
        super(message);
    }

    public MyStackException() {
    }
}
