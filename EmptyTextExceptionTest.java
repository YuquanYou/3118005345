import static org.junit.jupiter.api.Assertions.*;

public class EmptyTextExceptionTest {
    public static void main(String[] args){
        try{
            throw new EmptyTextException("Empty Text!");
        }catch(EmptyTextException e){
            e.printStackTrace();
        }
    }
}