package model.entity.myException;

public class ProductOutOfStockException extends RuntimeException{
    public ProductOutOfStockException(String message) {
        super(message);
    }
}
