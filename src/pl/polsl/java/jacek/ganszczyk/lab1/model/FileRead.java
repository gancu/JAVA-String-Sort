package pl.polsl.java.jacek.ganszczyk.lab1.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * FileRead reads from file given by user
 *
 * @author Jacek Ganszczyk
 * @version 1.0
 */
public class FileRead {

    /**
     * Field keeps name of file
     */
    private final String fileName;

    /**
     * Main class constructor
     * @param fileName saves to this field filename
     */
    public FileRead(String fileName) {
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
}
