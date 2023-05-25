
package controller.exception;

/**
 *
 * @author migue
 */
public class InvalidDataTypeException extends Exception{

    public InvalidDataTypeException() {
        super("Invalid data type");
    }

    public InvalidDataTypeException(String msg) {
        super(msg);
    }
}
