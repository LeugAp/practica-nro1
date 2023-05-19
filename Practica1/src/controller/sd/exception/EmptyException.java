/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
