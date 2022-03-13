import java.util.EmptyStackException;

public interface Stack<T> {

    public  boolean isEmpty();
    public  void push(T elm);
    public  T pop() throws EmptyStackException, EmptyListException;



}
