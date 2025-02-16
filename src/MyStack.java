import exceptions.StackException;

public class MyStack<E> {
    private E[] stack;
    private int top;

    public MyStack(int size) {
        stack = (E[]) new Object[size];
        top = -1;
    }

    public void push(E e) throws StackException {
        if (top == stack.length - 1) throw new StackException("Стек заполнен!");
        stack[++top] = e;
    }

    public E pop() throws StackException {
        if (top == -1) throw new StackException("Попытка извлечь из пустого стека!");
        return stack[top--];
    }

    public void print() {
        if (top == -1) {
            System.out.println("Стек пуст");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public void clear() {
        top = -1;
    }
}
