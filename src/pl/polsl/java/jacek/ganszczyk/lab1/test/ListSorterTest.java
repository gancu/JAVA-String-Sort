package pl.polsl.java.jacek.ganszczyk.lab1.test;

import org.junit.jupiter.api.Test;
import pl.polsl.java.jacek.ganszczyk.lab1.exceptions.NullListException;
import pl.polsl.java.jacek.ganszczyk.lab1.model.ListSorter;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ListSorterTest {
    ListSorter testListSorter = new ListSorter();
    LinkedList<String> testList = new LinkedList<>();

    //  @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testList.add("zzcv");
        testList.add("zazcv");
        testList.add("fzcv");
        testList.add("azcv");
    }

    @Test
    void AlphabeticalSortTest() throws NullListException {
        setUp();
        testListSorter.sortList(testList);
        assertEquals(testList.get(0), "azcv");
        assertEquals(testList.get(1), "fzcv");
        assertEquals(testList.get(2), "zazcv");
        assertEquals(testList.get(3), "zzcv");

    }

    @Test
    void EmptyListSort() throws NullListException {
        setUp();
        try {
            testListSorter.sortList(testList);
            fail("An exception should be thrown when the list is empty");
        } catch (NullListException e) {
            assertEquals(e.getMessage(), "Empty list of strings");
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        testList.clear();
    }
}
