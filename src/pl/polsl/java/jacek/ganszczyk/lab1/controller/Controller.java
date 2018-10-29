package pl.polsl.java.jacek.ganszczyk.lab1.controller;

import pl.polsl.java.jacek.ganszczyk.lab1.model.FileRead;
import pl.polsl.java.jacek.ganszczyk.lab1.model.ListSorter;
import pl.polsl.java.jacek.ganszczyk.lab1.view.View;

import java.io.IOException;
import java.util.LinkedList;

public class Controller
{
    private final View mainView;

    public Controller(View mainView) {
        this.mainView = new View();
    }

    public void sortStringsFromFile(String fileName) throws IOException {
        FileRead fileReader = new FileRead(fileName);
        LinkedList<String> listFromFile = fileReader.ReadStringsFromFile();

        ListSorter listSorter = new ListSorter();
        listSorter.sortList(listFromFile);
        printSortedList(listFromFile);
        }

        public void printSortedList(LinkedList sortedList){
        for(int i=0; i<sortedList.size();i++){
            mainView.showMessage(i + ": " + sortedList.get(i).toString());
        }
        }
}
