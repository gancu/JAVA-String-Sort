package pl.polsl.java.jacek.ganszczyk.lab1.controller;

import pl.polsl.java.jacek.ganszczyk.lab1.exceptions.NullListException;
import pl.polsl.java.jacek.ganszczyk.lab1.model.FileRead;
import pl.polsl.java.jacek.ganszczyk.lab1.model.ListSorter;
import pl.polsl.java.jacek.ganszczyk.lab1.view.View;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Main Controller of application.
 *
 * @author Jacek Ganszczyk
 * @version 1.0
 */
public class Controller {
    /**
     * Console output.
     */
    private final View mainView;

    /**
     * Console input.
     */
    private final Scanner input;

    /**
     * Constructor of Controller
     */
    public Controller() {
        this.mainView = new View();
        this.input = new Scanner(System.in);
    }

    /**
     * Main method of controller, you can choose if you want load data from file or from console
     *
     * @param args
     * @throws NullListException
     * @throws IOException
     */
    public void mainControllerMethod(String[] args) throws NullListException, IOException {
        String inputLine;
        if (args.length == 0) {
            mainView.showMessage("There is no fileName in parameters, type it end press enter (ex input.txt), or if you want to type words manually type -m");
            inputLine = input.nextLine();
            if (inputLine.compareToIgnoreCase("-m") == 0) {
                mainView.showMessage("Type each of word you want to put on sorted list and after each submit by pressing enter. After last type -s and press enter");
                this.sortStringsFromConsole();
            } else {
                this.sortStringsFromFile(inputLine);
            }
        } else {
            this.sortStringsFromFile(args[0]);
        }

    }

    /**
     * Method sortStringsFromFile loads data from file and sorts it
     * @param fileName
     * @throws IOException
     */
    public void sortStringsFromFile(String fileName) throws IOException {
        FileRead fileReader = new FileRead(fileName);
        LinkedList<String> listFromFile = fileReader.ReadStringsFromFile();

        ListSorter listSorter = new ListSorter();
        try {
            listSorter.sortList(listFromFile);
        } catch (NullListException e) {
            e.printStackTrace();
        }
        printSortedList(listFromFile);
    }

    /**
     * Method sortStringsFromConsole take data from user and sort it
     * @throws NullListException
     */
    public void sortStringsFromConsole() throws NullListException {
        boolean loop = true;
        ListSorter listSorter = new ListSorter();
        String inputLine = "";
        LinkedList<String> listFromConsole = new LinkedList<String>();
        while (loop) {
            inputLine = input.nextLine();
            if (inputLine.compareToIgnoreCase("-s") == 0) {
                loop = false;
            } else if(inputLine.trim().length() > 0){
                listFromConsole.add(inputLine);
            }
        }
        listSorter.sortList(listFromConsole);
        printSortedList(listFromConsole);
    }

    /**
     * Sends do View sorted list of words
     * @param sortedList
     */
    public void printSortedList(LinkedList sortedList) {
        for (int i = 0; i < sortedList.size(); i++) {
            mainView.showMessage(i + ": " + sortedList.get(i).toString());
        }
    }
}
