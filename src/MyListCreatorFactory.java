public class MyListCreatorFactory {
    MyList myList = null;

    public MyList createList (int type){

        switch(type){
            case 1 -> myList = new MyStack();
            case 2 -> myList = new MyArrayList();
        }

        System.out.println("Ваша коллекция - " + myList.getClass());
        return myList;
    }

    public void testMyArrayList() {
        System.out.println(myList.size());
        myList.print();
        myList.add(1);
        myList.print();
        myList.add(12);
        myList.print();
        myList.add(123);
        myList.print();
        System.out.println(myList.size());
        myList.add(4321);
        myList.print();
        System.out.println(myList.size());
        myList.add(2, 321);
        myList.print();
        System.out.println(myList.size());
        myList.add(4, 1234);
        myList.print();
        System.out.println(myList.size());

        ////////////////////////////////// удаляем элементы ////////////////////////////////

        myList.remove();
        myList.print();
        System.out.println(myList.size());

        myList.remove(1);
        // myArrayList.remove(10); // Здесь вылетит исключение, что Элемента с таким индексом не существует
        myList.print();
        System.out.println(myList.size());

        myList.clear();
        myList.print();
        System.out.println(myList.size());
    }

    public void testMyStack() {
        System.out.println("Размер коллекции = " + myList.size());
        myList.print();
        myList.add(1);
        myList.print();
        myList.add(12);
        myList.print();
        myList.add(123);
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());
        myList.add(4321);
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());
        myList.add(2, 321);
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());
        myList.add(4, 1234);
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());

        ////////////////////////////////// удаляем элементы ////////////////////////////////
        System.out.println("Удаляем элементы:");
        myList.remove();
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());

        myList.remove(1);
        // myArrayList.remove(10); // Здесь вылетит исключение, что Элемента с таким индексом не существует
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());

        myList.clear();
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());

        /////////////повтор //////////////////////
        myList.add(1);
        myList.print();
        myList.add(12);
        myList.print();
        myList.add(123);
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());
        myList.add(4321);
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());
        myList.add(2, 321);
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());
        myList.add(4, 1234);
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());

        ////////////////////////////////// удаляем элементы ////////////////////////////////

        myList.remove();
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());

        myList.remove(1);
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());

        myList.clear();
        myList.print();
        System.out.println("Размер коллекции = " + myList.size());
    }
}
