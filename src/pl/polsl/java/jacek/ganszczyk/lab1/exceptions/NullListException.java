package pl.polsl.java.jacek.ganszczyk.lab1.exceptions;

/**
 * My own exception, it is throwed when sorted list is empty
 *
 * @author Jacek Ganszczyk
 * @version 1.0
 */
public class NullListException extends Exception {

    /**
     * Default Constructor
     */
    public NullListException() {
    }


    /**
     * Parametrized Constructor
     *
     * @param message display when error occurse
     */
    public NullListException(String message) {
        super(message);
    }
}
