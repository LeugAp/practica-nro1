
package controller.sd.exception;

/**
 *
 * @author miguel
 */
public class EmptyException extends Exception {

    public EmptyException() {
        super("This position doesn't exist");
    }

    public EmptyException(String ms) {
        super(ms);
    }
}
