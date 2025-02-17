import exceptions.MyArrayListExceptions;

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
        if (top >= size) {
            list = extArr();
            size = list.length;
        }
        list[top++] = e;
    }

    @Override
    void add(int index, E e) {
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
        if (isEmpty()){
            try {
                throw new MyArrayListExceptions("Вы пытаетесь удалить из пустой коллекции!");
            } catch (MyArrayListExceptions e) {
                throw new RuntimeException(e);
            }
        }
        list[--top] = null;
    }

    @Override
    void remove(int index) {
        if (index > top) {
            try {
                throw new MyArrayListExceptions("Элемента с таким индексом не существует");
            } catch (MyArrayListExceptions e) {
                throw new RuntimeException(e);
            }
        }
        list = displaceReduce(index);
        list[--top] = null;
    }

    @Override
    void clear() {
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
        return size;
    }

    private E[] extArr(){
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
