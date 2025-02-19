
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MyList myList;

        System.out.println("Введите коллекцию с которой хотите работать:");
        System.out.println("0 - MyQueue");
        System.out.println("1 - MyStack");
        System.out.println("2 - MyLinkedList");
        System.out.println("3 - MyArrayList");
        System.out.println("4 - Выход из программы");
        System.out.println();

        int type;
        while (true) {
            String input = scanner.next();
            try {
                type = Integer.parseInt(input);
                if (type < 0 || type > 4) { // для очереди под цифрой 0 нужно будет реализовать свой интерфейс
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Введите допустимое число от 0 до 4");
                System.out.println("0 - MyQueue");
                System.out.println("1 - MyStack");
                System.out.println("2 - MyArrayList");
                System.out.println("3 - Выход из программы");
                System.out.println();
            }
        }

        if (type == 3) {
            System.exit(0);
        }

        if (type != 0){
            MyListCreatorFactory myListCreatorFactory = new MyListCreatorFactory();
            myList = myListCreatorFactory.createList(type);

            if (type == 1) {
                myListCreatorFactory.testMyStack();
            }
            if (type == 2) {
                myListCreatorFactory.testMyArrayList(); // запускаем тестирование нашего ArrayList
            }

        } else { // для очереди нет интерфейса
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
            myQueue.get();
            myQueue.get();
            System.out.println("Теперь наша очередь выглядит так:");
            myQueue.print();

            System.out.println();
            System.out.println("Очищаем очередь:");
            myQueue.clear();
            System.out.println("Теперь наша очередь выглядит так:");
            myQueue.print();
        }
    }
}
