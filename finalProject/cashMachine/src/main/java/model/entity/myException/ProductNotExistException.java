package model.entity.myException;

public class ProductNotExistException extends RuntimeException{
    public ProductNotExistException(String message) {
        super(message);
    }
}
