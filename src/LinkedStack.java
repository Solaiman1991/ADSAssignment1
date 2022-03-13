import java.util.EmptyStackException;


public class LinkedStack<T> implements Stack<T>{

    private LinkedList<T> list;


    public LinkedStack()
    {
        this.list = new LinkedList<>();
    }


    @Override
    public boolean isEmpty() {
        return  list.isEmpty();
    }

    @Override
    public void push(T elm) {
        list.addToFront(elm);

    }

    @Override
    public T pop() throws EmptyListException {
       return list.removeFirst();
    }
}
