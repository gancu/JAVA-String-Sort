package pl.polsl.java.jacek.ganszczyk.lab1;

import pl.polsl.java.jacek.ganszczyk.lab1.controller.Controller;
import pl.polsl.java.jacek.ganszczyk.lab1.exceptions.NullListException;
import pl.polsl.java.jacek.ganszczyk.lab1.view.View;

import java.io.IOException;

/**
 * Entry Point of application.
 *
 * @author Jacek Ganszczyk
 * @version 1.0
 */
public class AlphabeticalOrderSortApplication {
    /**
     * Main method, read file path from program parameters
     *
     */

    /**
     * Main method, read file path from program parameters
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException, NullListException {
        Controller controller = new Controller();
        controller.mainControllerMethod(args);
    }
}