package pl.polsl.java.jacek.ganszczyk.lab1.model;

import java.util.Collections;
import java.util.LinkedList;

public class ListSorter {

    /**
     * Implementation of sorting algorithm
     * @param lList with sorting elements
     */
    public void sortList(LinkedList<String> lList) {
        for (int i = 0; i < lList.size(); i++) {
            for (int j = 0; j < (lList.size()-1); j++) {
                    if(lList.get(j).compareToIgnoreCase(lList.get(j+1)) > 0){
                        Collections.swap(lList, j, j+1);
                }
            }
        }
    }
}
