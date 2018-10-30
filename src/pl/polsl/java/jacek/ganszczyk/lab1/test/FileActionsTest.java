package pl.polsl.java.jacek.ganszczyk.lab1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.polsl.java.jacek.ganszczyk.lab1.exceptions.NullListException;
import pl.polsl.java.jacek.ganszczyk.lab1.model.FileActions;
import pl.polsl.java.jacek.ganszczyk.lab1.model.ListSorter;

import java.io.IOException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileActionsTest {
    /**
     inputFile.txt - contains
     Wanna
     Ganna
     Anna
     */
    FileActions fileActions = new FileActions("testInput.txt");
    ListSorter testListSorter = new ListSorter();
    LinkedList<String> testList = new LinkedList<>();

    @BeforeEach
    void setUp() {
        String inputTab[] = new String[3];

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void readStringsFromFile() throws IOException {
        testList = fileActions.ReadStringsFromFile();
        assertEquals(testList.get(0),"Wanna");
        assertEquals(testList.get(0),"Ganna");
        assertEquals(testList.get(0),"Aanna");
    }

    @Test
    void saveSortedListToFile() throws NullListException, IOException {
        testList = fileActions.ReadStringsFromFile();
        testListSorter.sortList(testList);
        fileActions = new FileActions("sorted-testInput.txt");

        testList = fileActions.ReadStringsFromFile();
        assertEquals(testList.get(0),"Anna");
        assertEquals(testList.get(0),"Ganna");
        assertEquals(testList.get(0),"Wanna");
    }
}