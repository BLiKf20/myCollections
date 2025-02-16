public class MyListCreatorFactory {
    public MyList createList (int type){
        MyList list = null;

        switch(type){
            case 1 -> list = new MyStack();
            //case 2 -> list = new MyLinkedList();
            //case 3 -> list = new MyArrayList();
        }

        System.out.println("Ваша коллекция - " + list.getClass());
        return list;
    }
}
