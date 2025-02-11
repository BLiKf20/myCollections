import exceptions.MyQueueException;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(5);
        myQueue.add(8);
        myQueue.add(13);
        myQueue.add(21);
        System.out.println("Очередь содержит: " + myQueue.size() + " элемент(-ов)");
        myQueue.print();

        System.out.println();
        System.out.println("Извлекаем два элемента из очереди:");
        try {
            myQueue.get();
            myQueue.get();
        }catch (MyQueueException e){
            e.getMessage();
        }
        System.out.println("Теперь наша очередь выглядит так:");
        myQueue.print();

        System.out.println();
        System.out.println("Очищаем очередь:");
        myQueue.clear();
        System.out.println("Теперь наша очередь выглядит так:");
        myQueue.print();
    }
}
