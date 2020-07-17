/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author LENOVO ADMIN
 */
public class NewException extends Exception {
    public NewException(String message) {
       // super(message + ", please enter valid input");
        System.out.print("Enter Proper Value");

    }
}
