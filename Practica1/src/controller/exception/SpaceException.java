/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controller.exception;

/**
 *
 * @author miguel
 */
public class SpaceException extends Exception{

    /**
     * Creates a new instance of <code>SpaceException</code> without detail
     * message.
     */
    public SpaceException() {
        super("This position doesn't exist");
    }

    /**
     * Constructs an instance of <code>SpaceException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SpaceException(String msg) {
        super(msg);
    }
}
