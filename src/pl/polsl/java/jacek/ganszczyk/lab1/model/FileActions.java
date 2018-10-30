package pl.polsl.java.jacek.ganszczyk.lab1.model;

import java.io.*;
import java.util.LinkedList;

/**
 * FileActions reads from file given by user
 *
 * @author Jacek Ganszczyk
 * @version 1.0
 */
public class FileActions {

    /**
     * Field keeps name of file
     */
    private final String fileName;

    /**
     * Main class constructor
     * @param fileName saves to this field filename
     */
    public FileActions(String fileName) {
        this.fileName = fileName;
    }


    /**
     * Read words lien by line from given file
     *
     * @return List with strings
     * @throws java.io.IOException when there is a problem with file.
     */
    public LinkedList<String> ReadStringsFromFile() throws IOException {
        BufferedReader readBuffer;
        LinkedList<String> stringsFromFile = new LinkedList<>();
        String oneLine;
        try {
            readBuffer = new BufferedReader(new FileReader(fileName));
            do {
                oneLine = readBuffer.readLine();
                if (null != oneLine && oneLine.trim().length() > 0)
                    stringsFromFile.add(oneLine);
            }
            while (null != oneLine);
            readBuffer.close();
        } catch (IOException e) {
            throw e;
        }
        return stringsFromFile;
    }

    /**
     * Method saves sorted list to new file with sorted- prefix
     * @param sortedList sorted list to be save
     * @throws IOException throws when file is corrupted
     */
    public void SaveSortedListToFile(LinkedList<String> sortedList) throws IOException{
        BufferedWriter writeBuffer;
        try {
            writeBuffer = new BufferedWriter(new FileWriter("sorted-" + fileName, true));
            for (String item : sortedList) {
                writeBuffer.write(item);
                writeBuffer.newLine();
            }
            writeBuffer.close();
        } catch (IOException e) {
            throw e;
        }

    }
}
