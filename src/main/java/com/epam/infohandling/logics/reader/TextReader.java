package com.epam.infohandling.logics.reader;

import com.epam.infohandling.exception.TextReadingException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TextReader {
    private static String EOF_DELIMITER = "\\Z";

    public String readText(String filePath) throws TextReadingException{
        try(Scanner scanner = new Scanner(new File(filePath))) {
            return scanner.useDelimiter(EOF_DELIMITER).next();
        }catch (IOException e){
            throw new TextReadingException(e.getMessage(),e);
        }
    }
}
