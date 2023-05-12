/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
