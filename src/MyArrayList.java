import exceptions.MyCollectionsException;

public class MyArrayList<E> extends MyList<E>{

    //E[] list;
    private int size = 10;
    private int top = 0;

    public MyArrayList() {
        list = (E[]) new Object[size]; // по умолчанию создаем ArrayList на 10 элементов
    }

    public MyArrayList(int size) {
        this.size = size;
        list = (E[]) new Object[size]; // создаем ArrayList с количеством элементов size
    }

    @Override
    void add(E e) {
        System.out.println("Добавляем элемент в коллекцию: " + e);
        if (top >= size) {
            list = extArr();
            size = list.length;
        }
        list[top++] = e;
    }

    void add(int index, E e) {
        System.out.println("Добавляем элемент " + e + " в коллекцию по индексу: " + index);
        if (top >= size){
            list = extArr();
            size = list.length;
        }
        list = displaceExtend(index);
        list[index] = e;
        top++;
    }

    @Override
    void remove() {
        System.out.println("Удаляем элемент из коллекции");
        if (isEmpty()){
            try {
                throw new MyCollectionsException("Вы пытаетесь удалить из пустой коллекции!");
            } catch (MyCollectionsException e) {
                throw new RuntimeException(e);
            }
        }
        list[--top] = null;
    }

    void remove(int index) {
        System.out.println("Удаляем элемент из коллекции по индексу " + index);
        if (index > top) {
            try {
                throw new MyCollectionsException("Элемента с таким индексом в коллекции не существует");
            } catch (MyCollectionsException e) {
                throw new RuntimeException(e);
            }
        }
        list = displaceReduce(index);
        list[--top] = null;
    }

    @Override
    void clear() {
        System.out.println("Очищаем коллекцию");
        int temp = top;
        for (int i = 0; i < temp; i++) {
            list[i] = null;
            top--;
        }
        System.out.println(top);
    }

    @Override
    boolean isEmpty() {
        return size <= 0;
    }

    @Override
    int size() {
        System.out.println("Размер коллекции" + size);
        return size;
    }

    private E[] extArr(){ // метод для расширения нашего массива
        E[] temp = (E[]) new Object[(int) (size * 1.5 + 1)]; // временный массив
        System.arraycopy(list,0,temp,0, list.length);
        return temp;
    }

    private E[] displaceExtend(int index){
        E[] temp = list.clone();
        for (int i = index; i < top; i++){
            temp[i + 1] = list[i];
        }
        return temp;
    }

    private E[] displaceReduce(int index){
        E[] temp = list.clone();
        for (int i = index; i < top; i++){
            temp[i] = list[i + 1];
        }
        return temp;
    }
}
