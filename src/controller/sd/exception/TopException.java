
package controller.sd.exception;

/**
 *
 * @author miguel
 */
public class TopException extends Exception{

    /**
     * Creates a new instance of <code>TopException</code> without detail
     * message.
     */
    public TopException() {
        super("Is Full");
    }

    /**
     * Constructs an instance of <code>TopException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public TopException(String msg) {
        super(msg);
    }
}
