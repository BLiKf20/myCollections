public abstract class MyList<E> {
    abstract void add(E e); //добавить элемент
    abstract void add(int index, E e); // добавить элемент по определенному индексу
    abstract void get(E e); //получить элемент

    abstract int size(); // получить размер коллекции
    abstract boolean isEmpty(); // проверить пуста коллекция или нет
    abstract void clear(); // очистить коллекцию

}
