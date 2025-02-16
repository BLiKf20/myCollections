package exceptions;

/**
 * Если пытаемся добавить в заполненный стек или пытаемся извлечь элементы из пустого стека
 */

public class StackException extends Exception {
    public StackException(String message) {
        super(message);
    }

    public StackException() {
    }
}
