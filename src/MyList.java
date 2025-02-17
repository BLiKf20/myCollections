public abstract class MyList<E> {
    E[] list;
    abstract void add(E e);
    abstract void add(int index, E e);
    abstract void remove();
    abstract void remove(int index);
    abstract void clear();
    abstract boolean isEmpty();
    abstract int size();
    void print(){
        System.out.println("Печатаем элементы в коллекции:");
        for (var e : list){
            System.out.println(e);
        }
    }

}
