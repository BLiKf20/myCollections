import exceptions.StackException;

public class MyStack {
    private char[] stack;
    private int top;
    public MyStack(int size) {
        stack = new char[size];
        top = -1;
    }

    public void push(char c) throws StackException {
        if (top == stack.length - 1) throw new StackException("Стек заполнен!");
        stack[++top] = c;
    }

    public char pop() throws StackException {
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
