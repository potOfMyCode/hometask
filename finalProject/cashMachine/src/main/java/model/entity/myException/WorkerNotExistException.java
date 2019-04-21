package model.entity.myException;

public class WorkerNotExistException extends RuntimeException{
    public WorkerNotExistException(String message) {
        super(message);
    }
}
