import exceptions.MyQueueException;

public class MyQueue<E>{
    private ListNode<E> begin = null;
    private ListNode<E> end = null;

    public MyQueue() {

    }

    public MyQueue(ListNode<E> begin, ListNode<E> end) {
        this.begin = begin;
        this.end = end;
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
        ListNode<E> node = new ListNode<>(el, null); //создаем последний элемент с нулевой ссылкой
        if (end == null) { //список был пуст
            end = node; //обе ссылки на этот элемент
            begin = node;
            return;
        }
        end.next = node; //привязать элемент к списку
        end = node; //указатель конца передвинуть на новый элемент
    }

    public E get() throws MyQueueException {
        if (begin == null) {
            throw new MyQueueException("Очередь пуста"); // если пустой список
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
        if (begin == null) {
            System.out.println("Queue is empty");
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
        begin = null;
        end = null;
        //все элементы списка соберет сборщик мусора, поскольку к ним потерян доступ
    }
}
