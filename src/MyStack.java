import exceptions.StackException;

public class MyStack<E> extends MyList<E>{
    private E[] stack;
    private int top;

    public MyStack() {
        stack = (E[]) new Object[10]; // по умолчанию создается стек на 10 элементов
        top = -1;
        System.out.println("Создан стек по умолчанию на 10 элементов");
    }

    public MyStack(int size) {
        stack = (E[]) new Object[size];
        top = -1;
        System.out.println("Создан стек на " + size + " элементов");
    }

    public void push(E e) throws StackException {
        if (top == stack.length - 1) throw new StackException("Стек заполнен!");
        stack[++top] = e;
    }

    public E pop() throws StackException {
        if (isEmpty()) throw new StackException("Попытка извлечь из пустого стека!");
        return stack[top--];
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Стек пуст");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    @Override
    boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void clear() {
        top = -1;
    }
}
