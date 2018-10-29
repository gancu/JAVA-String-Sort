package pl.polsl.java.jacek.ganszczyk.lab1.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * FileRead class reads data from files.
 *
 * @author Jacek Ganszczyk
 * @version 1.0
 */
public class FileRead {

    /**
     * Field keeps name of file
     */
    private final String fileName;

    public FileRead(String fileName) {
        this.fileName = fileName;
    }


    /**
     * Read data from file
     *
     * @return List with data
     * @throws java.io.IOException when file can not be read
     */
    public LinkedList<String> ReadStringsFromFile() throws IOException {
        BufferedReader readBuffer;
        LinkedList<String> stringsFromFile = new LinkedList<>();
        String oneLine;
        try {
            readBuffer = new BufferedReader(new FileReader(fileName));
            do {
                oneLine = readBuffer.readLine();
                if(oneLine!=null)
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
