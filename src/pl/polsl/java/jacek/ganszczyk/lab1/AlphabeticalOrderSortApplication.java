package pl.polsl.java.jacek.ganszczyk.lab1;

import pl.polsl.java.jacek.ganszczyk.lab1.controller.Controller;
import pl.polsl.java.jacek.ganszczyk.lab1.view.View;

import java.io.IOException;
import java.util.Scanner;

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

public static void main(String[] args) throws IOException {
    View view = new View();
    Scanner input = new Scanner(System.in);
    String fileName;
    Controller controller = new Controller(view);
    if (args.length == 0) {
        view.showMessage("There is no fileName in parameters, type it end press enter (ex input.txt)");
        fileName = input.nextLine();
    } else {
        fileName = args[0];
    }

    controller.sortStringsFromFile(fileName);
}
}