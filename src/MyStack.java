import exceptions.MyCollectionsException;

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
    int size() {
        return top + 1;
    }

    @Override
    void add(E e) {
        System.out.println("Добавляем элемент в коллекцию: " + e);
        if (top == stack.length - 1) {
            try {
                throw new MyCollectionsException("Стек заполнен!");
            } catch (MyCollectionsException ex) {
                throw new RuntimeException(ex);
            }
        }
        stack[++top] = e;
    }

    @Override
    void add(int index, E e) {
        System.out.println("В коллекцию типа стек нельзя добавить элемент по индексу");
    }

    @Override
    void remove() {
        System.out.println("Удаляем элемент из коллекции");
        if (isEmpty()) {
            try {
                throw new MyCollectionsException("Попытка извлечь из пустого стека!");
            } catch (MyCollectionsException e) {
                throw new RuntimeException(e);
            }
        }
        stack[top--] = null;
    }

    @Override
    void remove(int index) {
        System.out.println("В коллекции типа стек нельзя удалить элемент по индексу");
    }

    @Override
    public void clear() {
        System.out.println("Очищаем коллекцию");
        top = -1;
    }
}
