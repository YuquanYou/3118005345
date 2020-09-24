public class EmptyTextException extends Exception{
    public EmptyTextException(){
        super();
    }
    public EmptyTextException(String message){
        super(message);
    }
    public EmptyTextException(String message, Throwable cause){
        super(message,cause);
    }
    public EmptyTextException(Throwable cause){
        super(cause);
    }
}

