
package controller.sd.exception;

/**
 *
 * @author miguel
 */
public class IndexException extends Exception {
    public IndexException() {
        super("This position doesn't exist");
    }

    public IndexException(String ms, Throwable cause) {
        super(ms, cause);
    }
}
