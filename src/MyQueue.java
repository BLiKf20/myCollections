import exceptions.MyCollectionsException;

public class MyQueue<E>{
    private ListNode<E> begin = null;
    private ListNode<E> end = null;

    public MyQueue() {

    }

    private class ListNode<E> {
        private E val;
        private ListNode next;

        ListNode() {

        }

        ListNode(E val) {
            this.val = val;
        }

        ListNode(E val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void add(E el) { //добавляем в конец очереди
        System.out.println("Добавляем в конец очереди: " + el);
        ListNode<E> node = new ListNode<>(el, null); //создаем последний элемент с нулевой ссылкой
        if (end == null) { //список был пуст
            end = node; //обе ссылки на этот элемент
            begin = node;
            return;
        }
        end.next = node; //привязать элемент к списку
        end = node; //указатель конца передвинуть на новый элемент
    }

    public E get() {
        System.out.println("Получить элемент из очереди");
        if (begin == null) {
            try {
                throw new MyCollectionsException("Очередь пустая"); // если пустой список
            } catch (MyCollectionsException e) {
                throw new RuntimeException(e);
            }
        }
        E tmp = begin.val; //делаем копию данных
        begin = begin.next; //начало - на следующий элемент
        //прежний первый элемент подберет сборщик мусора
        return tmp; //возвращаем данные из начала очереди
    }

    public int size() {
        int size = 0;
        if (begin == null) {
            return 0;
        }
        ListNode item = begin;
        while (item != null) {
            size++;
            item = item.next; //переходим к следующему элементу
        }
        return size;
    }

    public void print() { //печать очереди от начала к концу
        System.out.println("Печать очереди от начала к концу");
        if (begin == null) {
            System.out.println("Очередь пустая");
            return;
        }
        ListNode item = begin;
        while (item != null) {
            System.out.print(item.val + " ");
            item = item.next; //переходим к следующему элементу
        }
        System.out.println();
    }

    public void clear() { //очистка очереди
        System.out.println("Очистка очереди");
        begin = null;
        end = null;
        //все элементы списка соберет сборщик мусора, поскольку к ним потерян доступ
    }
}
